package com.usl.microservices.sampleeventsourcing.persistence;

import com.usl.microservices.sampleeventsourcing.persistence.model.InsurancePersistenceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceEventDBRepository extends JpaRepository<InsurancePersistenceEvent, Integer> {

    public List<InsurancePersistenceEvent> findByInsuranceIdOrderByCreatedAtAsc(String insuranceId);

    public int countByInsuranceId(String insuranceId);

}