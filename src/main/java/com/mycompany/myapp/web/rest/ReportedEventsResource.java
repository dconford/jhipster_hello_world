package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ReportedEventsService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.ReportedEventsDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ReportedEvents}.
 */
@RestController
@RequestMapping("/api")
public class ReportedEventsResource {

    private final Logger log = LoggerFactory.getLogger(ReportedEventsResource.class);

    private static final String ENTITY_NAME = "reportedEvents";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReportedEventsService reportedEventsService;

    public ReportedEventsResource(ReportedEventsService reportedEventsService) {
        this.reportedEventsService = reportedEventsService;
    }

    /**
     * {@code POST  /reported-events} : Create a new reportedEvents.
     *
     * @param reportedEventsDTO the reportedEventsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reportedEventsDTO, or with status {@code 400 (Bad Request)} if the reportedEvents has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reported-events")
    public ResponseEntity<ReportedEventsDTO> createReportedEvents(@RequestBody ReportedEventsDTO reportedEventsDTO) throws URISyntaxException {
        log.debug("REST request to save ReportedEvents : {}", reportedEventsDTO);
        if (reportedEventsDTO.getId() != null) {
            throw new BadRequestAlertException("A new reportedEvents cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReportedEventsDTO result = reportedEventsService.save(reportedEventsDTO);
        return ResponseEntity.created(new URI("/api/reported-events/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reported-events} : Updates an existing reportedEvents.
     *
     * @param reportedEventsDTO the reportedEventsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reportedEventsDTO,
     * or with status {@code 400 (Bad Request)} if the reportedEventsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reportedEventsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reported-events")
    public ResponseEntity<ReportedEventsDTO> updateReportedEvents(@RequestBody ReportedEventsDTO reportedEventsDTO) throws URISyntaxException {
        log.debug("REST request to update ReportedEvents : {}", reportedEventsDTO);
        if (reportedEventsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReportedEventsDTO result = reportedEventsService.save(reportedEventsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, reportedEventsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reported-events} : get all the reportedEvents.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reportedEvents in body.
     */
    @GetMapping("/reported-events")
    public ResponseEntity<List<ReportedEventsDTO>> getAllReportedEvents(Pageable pageable) {
        log.debug("REST request to get a page of ReportedEvents");
        Page<ReportedEventsDTO> page = reportedEventsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reported-events/:id} : get the "id" reportedEvents.
     *
     * @param id the id of the reportedEventsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reportedEventsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reported-events/{id}")
    public ResponseEntity<ReportedEventsDTO> getReportedEvents(@PathVariable Long id) {
        log.debug("REST request to get ReportedEvents : {}", id);
        Optional<ReportedEventsDTO> reportedEventsDTO = reportedEventsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reportedEventsDTO);
    }

    /**
     * {@code DELETE  /reported-events/:id} : delete the "id" reportedEvents.
     *
     * @param id the id of the reportedEventsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reported-events/{id}")
    public ResponseEntity<Void> deleteReportedEvents(@PathVariable Long id) {
        log.debug("REST request to delete ReportedEvents : {}", id);
        reportedEventsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
