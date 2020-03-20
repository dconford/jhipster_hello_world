package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.ReportedEventsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.ReportedEvents}.
 */
public interface ReportedEventsService {

    /**
     * Save a reportedEvents.
     *
     * @param reportedEventsDTO the entity to save.
     * @return the persisted entity.
     */
    ReportedEventsDTO save(ReportedEventsDTO reportedEventsDTO);

    /**
     * Get all the reportedEvents.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReportedEventsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" reportedEvents.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReportedEventsDTO> findOne(Long id);

    /**
     * Delete the "id" reportedEvents.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
