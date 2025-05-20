package com.hub.companyms.application;

import com.hub.companyms.application.representation.SegmentDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/segment")
public class SegmentController {

    @Autowired
    private SegmentService service;

    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody SegmentDto req) {
        return service.create(req);
    }

    @PutMapping()
    public ResponseEntity update(@Valid @RequestBody SegmentDto req){
        return service.update(req);
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestParam("segment") Long id){
        return service.delete(id);
    }

}
