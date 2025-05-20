package com.hub.companyms.application;

import com.hub.companyms.application.representation.SegmentDto;
import com.hub.companyms.infra.repository.SegmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SegmentService {

    @Autowired
    private SegmentRespository respository;

    public ResponseEntity create(SegmentDto req) {

        return null;
    }

    public ResponseEntity update(SegmentDto req) {

        return null;

    }

    public ResponseEntity delete(Long id) {
        return null;
    }
}
