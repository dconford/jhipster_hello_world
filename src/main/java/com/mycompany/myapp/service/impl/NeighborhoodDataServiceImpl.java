package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.NeighborhoodDataService;
import com.mycompany.myapp.domain.NeighborhoodData;
import com.mycompany.myapp.repository.NeighborhoodDataRepository;
import com.mycompany.myapp.service.dto.NeighborhoodDataDTO;
import com.mycompany.myapp.service.mapper.NeighborhoodDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link NeighborhoodData}.
 */
@Service
@Transactional
public class NeighborhoodDataServiceImpl implements NeighborhoodDataService {

    private final Logger log = LoggerFactory.getLogger(NeighborhoodDataServiceImpl.class);

    private final NeighborhoodDataRepository neighborhoodDataRepository;

    private final NeighborhoodDataMapper neighborhoodDataMapper;

    public NeighborhoodDataServiceImpl(NeighborhoodDataRepository neighborhoodDataRepository, NeighborhoodDataMapper neighborhoodDataMapper) {
        this.neighborhoodDataRepository = neighborhoodDataRepository;
        this.neighborhoodDataMapper = neighborhoodDataMapper;
    }

    /**
     * Save a neighborhoodData.
     *
     * @param neighborhoodDataDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public NeighborhoodDataDTO save(NeighborhoodDataDTO neighborhoodDataDTO) {
        log.debug("Request to save NeighborhoodData : {}", neighborhoodDataDTO);
        NeighborhoodData neighborhoodData = neighborhoodDataMapper.toEntity(neighborhoodDataDTO);
        neighborhoodData = neighborhoodDataRepository.save(neighborhoodData);
        return neighborhoodDataMapper.toDto(neighborhoodData);
    }

    /**
     * Get all the neighborhoodData.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<NeighborhoodDataDTO> findAll() {
        log.debug("Request to get all NeighborhoodData");
        return neighborhoodDataRepository.findAll().stream()
            .map(neighborhoodDataMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one neighborhoodData by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<NeighborhoodDataDTO> findOne(Long id) {
        log.debug("Request to get NeighborhoodData : {}", id);
        return neighborhoodDataRepository.findById(id)
            .map(neighborhoodDataMapper::toDto);
    }

    /**
     * Delete the neighborhoodData by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete NeighborhoodData : {}", id);
        neighborhoodDataRepository.deleteById(id);
    }
}
