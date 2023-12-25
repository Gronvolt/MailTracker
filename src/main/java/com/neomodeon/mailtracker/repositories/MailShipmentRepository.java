package com.neomodeon.mailtracker.repositories;

import com.neomodeon.mailtracker.entities.MailShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailShipmentRepository extends JpaRepository<MailShipment, Long> {
}
