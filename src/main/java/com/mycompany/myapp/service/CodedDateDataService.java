package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.CodedDateDataDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.CodedDateData}.
 */
public interface CodedDateDataService {

    /**
     * Save a codedDateData.
     *
     * @param codedDateDataDTO the entity to save.
     * @return the persisted entity.
     */
    CodedDateDataDTO save(CodedDateDataDTO codedDateDataDTO);

    /**
     * Get all the codedDateData.
     *
     * @return the list of entities.
     */
    List<CodedDateDataDTO> findAll();

    /**
     * Get the "id" codedDateData.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CodedDateDataDTO> findOne(Long id);

    /**
     * Delete the "id" codedDateData.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
