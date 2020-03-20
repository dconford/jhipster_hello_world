package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.CrimeCategoryDataDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.CrimeCategoryData}.
 */
public interface CrimeCategoryDataService {

    /**
     * Save a crimeCategoryData.
     *
     * @param crimeCategoryDataDTO the entity to save.
     * @return the persisted entity.
     */
    CrimeCategoryDataDTO save(CrimeCategoryDataDTO crimeCategoryDataDTO);

    /**
     * Get all the crimeCategoryData.
     *
     * @return the list of entities.
     */
    List<CrimeCategoryDataDTO> findAll();

    /**
     * Get the "id" crimeCategoryData.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CrimeCategoryDataDTO> findOne(Long id);

    /**
     * Delete the "id" crimeCategoryData.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
