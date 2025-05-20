package com.hub.companyms.application.representation;

import com.hub.companyms.domain.Company;
import com.hub.companyms.domain.SubscriptionPlan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CompanyDto(
        @NotNull @NotBlank @Size(min = 3, max = 20)
        String name,

        @NotNull @NotBlank @Size(min = 2)
        String identification,

        @NotNull @NotBlank @Size(min = 2)
        String domain,

        @NotNull
        SubscriptionPlan plan,

        @NotNull
        AdminDto admin
) {

        public Company toEntity() {
                Company company = new Company();
                company.setName(this.name);
                company.setDomain(this.domain);
                company.setPlan(this.plan);
                company.setTaxIdentification(this.identification);
                return company;
        }
}

