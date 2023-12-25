package com.neomodeon.mailtracker.repositories;

import com.neomodeon.mailtracker.entities.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
}
