package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ReportedEvents;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ReportedEvents entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReportedEventsRepository extends JpaRepository<ReportedEvents, Long> {

}
