package com.hub.companyms.application;

import com.hub.companyms.application.representation.AdminDto;
import com.hub.companyms.application.representation.CompanyDto;
import com.hub.companyms.domain.Company;
import com.hub.companyms.infra.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public ResponseEntity<?> createCompany(@Valid CompanyDto req) {
        if (repository.findByName(req.name())) {
            throw new DuplicateKeyException("Company with name: " + req.name() + " already exists");
        }

        if (repository.findByDomain(req.domain())) {
            throw new DuplicateKeyException("Company with domain: " + req.domain() + " already exists");
        }

        Company company = repository.save(req.toEntity());

        // Emitir evento para criar admin (stub por enquanto)
        createAdmin(req.admin(), company.getCompanyId());

        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    public ResponseEntity<?> saveLogo(MultipartFile file, Long id) throws Exception {
        Company company = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));

        company.setLogo(file.getBytes());
        repository.save(company);

        return ResponseEntity.ok().body("Logo uploaded successfully");
    }

    public ResponseEntity<?> update(CompanyDto req) {

        Company company = repository.save(req.toEntity());

        return ResponseEntity.ok(company);
    }

    public ResponseEntity<?> updateLogo(MultipartFile file, Long id) {
        try {
            Company company = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Company not found"));

            company.setLogo(file.getBytes());
            repository.save(company);

            return ResponseEntity.ok("Logo updated successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating logo");
        }
    }

    public ResponseEntity<?> delete(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
        }

        repository.deleteById(id);
        return ResponseEntity.ok().body("Company deleted");
    }

    private boolean createAdmin(AdminDto admin, Long companyId) {
        // TODO: Enviar evento para RabbitMQ com dados do admin e companyId
        return true;
    }
}
