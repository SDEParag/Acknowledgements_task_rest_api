package com.assessmentrestapi.controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assessmentrestapi.dto.AcknowledgeDTO;
import com.assessmentrestapi.entity.Acknowledge;
import com.assessmentrestapi.service.AcknowledgeService;

@RestController
@RequestMapping("/api/acknowledgements")
public class AcknowledgeController {

    private static final Logger logger = LoggerFactory.getLogger(AcknowledgeController.class);

    @Autowired
    private AcknowledgeService acknowledgeService;

    // ✅ Save Acknowledgement
    @PostMapping
    public ResponseEntity<Acknowledge> saveAcknowledgement(@RequestBody AcknowledgeDTO dto) {
        logger.info("Saving acknowledgement for user: {}", dto.getUserName());
        return ResponseEntity.ok(acknowledgeService.saveAcknowledgement(dto));
    }

    // ✅ Get Acknowledgement by User
    @GetMapping("/{userName}")
    public ResponseEntity<List<Acknowledge>> getAcknowledgementsByUser(@PathVariable String userName) {
        logger.info("Fetching acknowledgements for user: {}", userName);
        return ResponseEntity.ok(acknowledgeService.getAcknowledgementsByUser(userName));
    }

    // ✅ Update Acknowledgement by ID
    @PutMapping("/{id}")
    public ResponseEntity<Acknowledge> updateAcknowledgement(@PathVariable Long id, @RequestBody AcknowledgeDTO dto) {
        logger.info("Updating acknowledgement ID: {}", id);
        return ResponseEntity.ok(acknowledgeService.updateAcknowledgement(id, dto));
    }

    // ✅ Delete Acknowledgement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAcknowledgement(@PathVariable Long id) {
        logger.info("Deleting acknowledgement ID: {}", id);
        acknowledgeService.deleteAcknowledgement(id);
        return ResponseEntity.ok("Acknowledgement deleted successfully!");
    }
}