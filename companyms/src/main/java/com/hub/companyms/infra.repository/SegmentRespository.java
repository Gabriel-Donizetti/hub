package com.hub.companyms.infra.repository;

import com.hub.companyms.domain.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRespository extends JpaRepository<Segment, Long> {
}
