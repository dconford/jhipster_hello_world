package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CodedDateDataService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.CodedDateDataDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.CodedDateData}.
 */
@RestController
@RequestMapping("/api")
public class CodedDateDataResource {

    private final Logger log = LoggerFactory.getLogger(CodedDateDataResource.class);

    private static final String ENTITY_NAME = "codedDateData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CodedDateDataService codedDateDataService;

    public CodedDateDataResource(CodedDateDataService codedDateDataService) {
        this.codedDateDataService = codedDateDataService;
    }

    /**
     * {@code POST  /coded-date-data} : Create a new codedDateData.
     *
     * @param codedDateDataDTO the codedDateDataDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new codedDateDataDTO, or with status {@code 400 (Bad Request)} if the codedDateData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/coded-date-data")
    public ResponseEntity<CodedDateDataDTO> createCodedDateData(@RequestBody CodedDateDataDTO codedDateDataDTO) throws URISyntaxException {
        log.debug("REST request to save CodedDateData : {}", codedDateDataDTO);
        if (codedDateDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new codedDateData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CodedDateDataDTO result = codedDateDataService.save(codedDateDataDTO);
        return ResponseEntity.created(new URI("/api/coded-date-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /coded-date-data} : Updates an existing codedDateData.
     *
     * @param codedDateDataDTO the codedDateDataDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated codedDateDataDTO,
     * or with status {@code 400 (Bad Request)} if the codedDateDataDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the codedDateDataDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/coded-date-data")
    public ResponseEntity<CodedDateDataDTO> updateCodedDateData(@RequestBody CodedDateDataDTO codedDateDataDTO) throws URISyntaxException {
        log.debug("REST request to update CodedDateData : {}", codedDateDataDTO);
        if (codedDateDataDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CodedDateDataDTO result = codedDateDataService.save(codedDateDataDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, codedDateDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /coded-date-data} : get all the codedDateData.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of codedDateData in body.
     */
    @GetMapping("/coded-date-data")
    public List<CodedDateDataDTO> getAllCodedDateData() {
        log.debug("REST request to get all CodedDateData");
        return codedDateDataService.findAll();
    }

    /**
     * {@code GET  /coded-date-data/:id} : get the "id" codedDateData.
     *
     * @param id the id of the codedDateDataDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the codedDateDataDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/coded-date-data/{id}")
    public ResponseEntity<CodedDateDataDTO> getCodedDateData(@PathVariable Long id) {
        log.debug("REST request to get CodedDateData : {}", id);
        Optional<CodedDateDataDTO> codedDateDataDTO = codedDateDataService.findOne(id);
        return ResponseUtil.wrapOrNotFound(codedDateDataDTO);
    }

    /**
     * {@code DELETE  /coded-date-data/:id} : delete the "id" codedDateData.
     *
     * @param id the id of the codedDateDataDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/coded-date-data/{id}")
    public ResponseEntity<Void> deleteCodedDateData(@PathVariable Long id) {
        log.debug("REST request to delete CodedDateData : {}", id);
        codedDateDataService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
