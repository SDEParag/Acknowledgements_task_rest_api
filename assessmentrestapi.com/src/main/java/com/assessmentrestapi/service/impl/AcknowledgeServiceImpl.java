package com.assessmentrestapi.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessmentrestapi.dto.AcknowledgeDTO;
import com.assessmentrestapi.entity.Acknowledge;
import com.assessmentrestapi.repository.AcknowledgeRepository;
import com.assessmentrestapi.service.AcknowledgeService;

@Service
public class AcknowledgeServiceImpl implements AcknowledgeService {

    private static final Logger logger = LoggerFactory.getLogger(AcknowledgeServiceImpl.class);

    @Autowired
    private AcknowledgeRepository acknowledgeRepository;

 
    private static final Map<String, String> MESSAGE_TEMPLATES = new HashMap<>();

    static {
        MESSAGE_TEMPLATES.put("client1", "I %s do acknowledge to accept the terms at %s");
        MESSAGE_TEMPLATES.put("client2", "I %s agree that I have read the terms and conditions at %s");
    }

    @Override
    public Acknowledge saveAcknowledgement(AcknowledgeDTO dto) {
        String message = generateMessage(dto.getUserName(), dto.getClientName());
        Acknowledge acknowledge = new Acknowledge(dto.getUserName(), dto.getClientName(), message);
        Acknowledge saved = acknowledgeRepository.save(acknowledge);
        logger.info("Acknowledgement saved: {}", saved);
        return saved;
    }

    @Override
    public List<Acknowledge> getAcknowledgementsByUser(String userName) {
        return acknowledgeRepository.findByUserName(userName);
    }

    @Override
    public Acknowledge updateAcknowledgement(Long id, AcknowledgeDTO dto) {
        Optional<Acknowledge> optionalAcknowledge = acknowledgeRepository.findById(id);
        if (optionalAcknowledge.isPresent()) {
            Acknowledge existing = optionalAcknowledge.get();
            existing.setUserName(dto.getUserName());
            existing.setClientName(dto.getClientName());
            existing.setMessage(generateMessage(dto.getUserName(), dto.getClientName()));
            existing.setTimestamp(LocalDateTime.now()); // Updating timestamp
            return acknowledgeRepository.save(existing);
        } else {
            throw new RuntimeException("Acknowledgement not found with ID: " + id);
        }
    }

    @Override
    public void deleteAcknowledgement(Long id) {
        acknowledgeRepository.deleteById(id);
    }

    private String generateMessage(String userName, String clientName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z").withZone(ZoneId.of("Asia/Kolkata"));
        String formattedTimestamp = LocalDateTime.now().format(formatter);

     
        String template = MESSAGE_TEMPLATES.getOrDefault(clientName.toLowerCase(), "Acknowledgment message not found for %s");
        return String.format(template, userName, formattedTimestamp);
    }
}
