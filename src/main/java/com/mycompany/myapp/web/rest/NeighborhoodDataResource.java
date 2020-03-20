package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.NeighborhoodDataService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.NeighborhoodDataDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.NeighborhoodData}.
 */
@RestController
@RequestMapping("/api")
public class NeighborhoodDataResource {

    private final Logger log = LoggerFactory.getLogger(NeighborhoodDataResource.class);

    private static final String ENTITY_NAME = "neighborhoodData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NeighborhoodDataService neighborhoodDataService;

    public NeighborhoodDataResource(NeighborhoodDataService neighborhoodDataService) {
        this.neighborhoodDataService = neighborhoodDataService;
    }

    /**
     * {@code POST  /neighborhood-data} : Create a new neighborhoodData.
     *
     * @param neighborhoodDataDTO the neighborhoodDataDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new neighborhoodDataDTO, or with status {@code 400 (Bad Request)} if the neighborhoodData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/neighborhood-data")
    public ResponseEntity<NeighborhoodDataDTO> createNeighborhoodData(@Valid @RequestBody NeighborhoodDataDTO neighborhoodDataDTO) throws URISyntaxException {
        log.debug("REST request to save NeighborhoodData : {}", neighborhoodDataDTO);
        if (neighborhoodDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new neighborhoodData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NeighborhoodDataDTO result = neighborhoodDataService.save(neighborhoodDataDTO);
        return ResponseEntity.created(new URI("/api/neighborhood-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /neighborhood-data} : Updates an existing neighborhoodData.
     *
     * @param neighborhoodDataDTO the neighborhoodDataDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated neighborhoodDataDTO,
     * or with status {@code 400 (Bad Request)} if the neighborhoodDataDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the neighborhoodDataDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/neighborhood-data")
    public ResponseEntity<NeighborhoodDataDTO> updateNeighborhoodData(@Valid @RequestBody NeighborhoodDataDTO neighborhoodDataDTO) throws URISyntaxException {
        log.debug("REST request to update NeighborhoodData : {}", neighborhoodDataDTO);
        if (neighborhoodDataDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NeighborhoodDataDTO result = neighborhoodDataService.save(neighborhoodDataDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, neighborhoodDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /neighborhood-data} : get all the neighborhoodData.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of neighborhoodData in body.
     */
    @GetMapping("/neighborhood-data")
    public List<NeighborhoodDataDTO> getAllNeighborhoodData() {
        log.debug("REST request to get all NeighborhoodData");
        return neighborhoodDataService.findAll();
    }

    /**
     * {@code GET  /neighborhood-data/:id} : get the "id" neighborhoodData.
     *
     * @param id the id of the neighborhoodDataDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the neighborhoodDataDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/neighborhood-data/{id}")
    public ResponseEntity<NeighborhoodDataDTO> getNeighborhoodData(@PathVariable Long id) {
        log.debug("REST request to get NeighborhoodData : {}", id);
        Optional<NeighborhoodDataDTO> neighborhoodDataDTO = neighborhoodDataService.findOne(id);
        return ResponseUtil.wrapOrNotFound(neighborhoodDataDTO);
    }

    /**
     * {@code DELETE  /neighborhood-data/:id} : delete the "id" neighborhoodData.
     *
     * @param id the id of the neighborhoodDataDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/neighborhood-data/{id}")
    public ResponseEntity<Void> deleteNeighborhoodData(@PathVariable Long id) {
        log.debug("REST request to delete NeighborhoodData : {}", id);
        neighborhoodDataService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
