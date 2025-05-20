package com.hub.companyms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message = "The field must contain at least 3 characters and a maximum of 20")
    private String name;

    @NotNull
    @NotBlank
    private String taxIdentification;

    @NotNull
    @NotBlank
    @Size(min = 2, message = "The field must be at least 2 characteres")
    private String domain;

    @Lob
    @JdbcTypeCode(Types.BINARY)
    private byte[] logo;

    private SubscriptionPlan plan;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "Company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Segment> segments;
}
