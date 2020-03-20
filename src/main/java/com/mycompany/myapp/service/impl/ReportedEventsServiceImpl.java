package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.ReportedEventsService;
import com.mycompany.myapp.domain.ReportedEvents;
import com.mycompany.myapp.repository.ReportedEventsRepository;
import com.mycompany.myapp.service.dto.ReportedEventsDTO;
import com.mycompany.myapp.service.mapper.ReportedEventsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ReportedEvents}.
 */
@Service
@Transactional
public class ReportedEventsServiceImpl implements ReportedEventsService {

    private final Logger log = LoggerFactory.getLogger(ReportedEventsServiceImpl.class);

    private final ReportedEventsRepository reportedEventsRepository;

    private final ReportedEventsMapper reportedEventsMapper;

    public ReportedEventsServiceImpl(ReportedEventsRepository reportedEventsRepository, ReportedEventsMapper reportedEventsMapper) {
        this.reportedEventsRepository = reportedEventsRepository;
        this.reportedEventsMapper = reportedEventsMapper;
    }

    /**
     * Save a reportedEvents.
     *
     * @param reportedEventsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReportedEventsDTO save(ReportedEventsDTO reportedEventsDTO) {
        log.debug("Request to save ReportedEvents : {}", reportedEventsDTO);
        ReportedEvents reportedEvents = reportedEventsMapper.toEntity(reportedEventsDTO);
        reportedEvents = reportedEventsRepository.save(reportedEvents);
        return reportedEventsMapper.toDto(reportedEvents);
    }

    /**
     * Get all the reportedEvents.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReportedEventsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ReportedEvents");
        return reportedEventsRepository.findAll(pageable)
            .map(reportedEventsMapper::toDto);
    }

    /**
     * Get one reportedEvents by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReportedEventsDTO> findOne(Long id) {
        log.debug("Request to get ReportedEvents : {}", id);
        return reportedEventsRepository.findById(id)
            .map(reportedEventsMapper::toDto);
    }

    /**
     * Delete the reportedEvents by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReportedEvents : {}", id);
        reportedEventsRepository.deleteById(id);
    }
}
