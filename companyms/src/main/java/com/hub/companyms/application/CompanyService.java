package com.hub.companyms.application;

import com.hub.companyms.application.representation.AdminDto;
import com.hub.companyms.application.representation.CompanyDto;
import com.hub.companyms.domain.Company;
import com.hub.companyms.infra.repository.CompanyRepository;
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

    public ResponseEntity createCompany(CompanyDto req) {

        if (repository.findByName(req.name())) {
            throw new DuplicateKeyException("Company with name:" + req.name() + "already exists");
        }

        if (repository.findByDomain(req.domain())) {
            throw new DuplicateKeyException("Company with domain:" + req.domain() + "already exists");
        }

        Company company = repository.save(req.toEntity());

        //TODO: implementar mensagem de erro
        createAdmin(req.admin(), company.getCompanyId());

        return ResponseEntity.status(HttpStatus.CREATED).body(company);

    }

    public ResponseEntity saveLogo(MultipartFile file, Long id) {

        return null;
    }

    public ResponseEntity update(CompanyDto req) {

        return null;

    }

    public ResponseEntity updateLogo(MultipartFile file, Long id) {
        return null;
    }

    public ResponseEntity delete(Long id) {
        return null;
    }

    private boolean createAdmin(AdminDto admin, Long companyt) {

        //TODO: implementar serviço de mensageria para emitir evento de criação do usuario admin

        return false;
    }
}
