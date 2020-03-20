package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.NeighborhoodDataDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.NeighborhoodData}.
 */
public interface NeighborhoodDataService {

    /**
     * Save a neighborhoodData.
     *
     * @param neighborhoodDataDTO the entity to save.
     * @return the persisted entity.
     */
    NeighborhoodDataDTO save(NeighborhoodDataDTO neighborhoodDataDTO);

    /**
     * Get all the neighborhoodData.
     *
     * @return the list of entities.
     */
    List<NeighborhoodDataDTO> findAll();

    /**
     * Get the "id" neighborhoodData.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NeighborhoodDataDTO> findOne(Long id);

    /**
     * Delete the "id" neighborhoodData.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
