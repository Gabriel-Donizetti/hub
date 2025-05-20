package com.hub.companyms.infra.repository;

import com.hub.companyms.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean findByName(String name);

    boolean findByDomain(String domain);
}
