package com.hub.companyms.application;

import com.hub.companyms.application.representation.CompanyDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/create")
    public ResponseEntity<?> createCompany(@Valid @RequestBody CompanyDto req) throws Exception {
        return service.createCompany(req);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCompany(@Valid @RequestBody CompanyDto req) throws Exception {
        return service.update(req);
    }

    @PostMapping("/logo")
    public ResponseEntity<?> saveLogo(@RequestParam("file") MultipartFile file, @RequestParam("company") Long id) throws Exception {
        return service.saveLogo(file, id);
    }

    @PutMapping("/logo/update")
    public ResponseEntity<?> updateLogo(@RequestParam("file") MultipartFile file, @RequestParam("company") Long id) throws Exception {
        return service.updateLogo(file, id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCompany(@RequestParam("company") Long id) throws Exception {
        return service.delete(id);
    }


}
