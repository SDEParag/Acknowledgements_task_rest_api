package com.assessmentrestapi.service;


import java.util.List;

import com.assessmentrestapi.dto.AcknowledgeDTO;
import com.assessmentrestapi.entity.Acknowledge;

public interface AcknowledgeService {
    Acknowledge saveAcknowledgement(AcknowledgeDTO dto);
    List<Acknowledge> getAcknowledgementsByUser(String userName);
    Acknowledge updateAcknowledgement(Long id, AcknowledgeDTO dto);
    void deleteAcknowledgement(Long id);
}
