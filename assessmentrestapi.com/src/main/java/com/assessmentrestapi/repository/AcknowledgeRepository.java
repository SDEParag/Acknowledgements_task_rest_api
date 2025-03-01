package com.assessmentrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessmentrestapi.entity.Acknowledge;

public interface AcknowledgeRepository extends JpaRepository<Acknowledge, Long> {
    List<Acknowledge> findByUserName(String userName);
}