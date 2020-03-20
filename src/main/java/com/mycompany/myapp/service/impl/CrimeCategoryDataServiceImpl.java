package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.CrimeCategoryDataService;
import com.mycompany.myapp.domain.CrimeCategoryData;
import com.mycompany.myapp.repository.CrimeCategoryDataRepository;
import com.mycompany.myapp.service.dto.CrimeCategoryDataDTO;
import com.mycompany.myapp.service.mapper.CrimeCategoryDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link CrimeCategoryData}.
 */
@Service
@Transactional
public class CrimeCategoryDataServiceImpl implements CrimeCategoryDataService {

    private final Logger log = LoggerFactory.getLogger(CrimeCategoryDataServiceImpl.class);

    private final CrimeCategoryDataRepository crimeCategoryDataRepository;

    private final CrimeCategoryDataMapper crimeCategoryDataMapper;

    public CrimeCategoryDataServiceImpl(CrimeCategoryDataRepository crimeCategoryDataRepository, CrimeCategoryDataMapper crimeCategoryDataMapper) {
        this.crimeCategoryDataRepository = crimeCategoryDataRepository;
        this.crimeCategoryDataMapper = crimeCategoryDataMapper;
    }

    /**
     * Save a crimeCategoryData.
     *
     * @param crimeCategoryDataDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CrimeCategoryDataDTO save(CrimeCategoryDataDTO crimeCategoryDataDTO) {
        log.debug("Request to save CrimeCategoryData : {}", crimeCategoryDataDTO);
        CrimeCategoryData crimeCategoryData = crimeCategoryDataMapper.toEntity(crimeCategoryDataDTO);
        crimeCategoryData = crimeCategoryDataRepository.save(crimeCategoryData);
        return crimeCategoryDataMapper.toDto(crimeCategoryData);
    }

    /**
     * Get all the crimeCategoryData.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CrimeCategoryDataDTO> findAll() {
        log.debug("Request to get all CrimeCategoryData");
        return crimeCategoryDataRepository.findAll().stream()
            .map(crimeCategoryDataMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one crimeCategoryData by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CrimeCategoryDataDTO> findOne(Long id) {
        log.debug("Request to get CrimeCategoryData : {}", id);
        return crimeCategoryDataRepository.findById(id)
            .map(crimeCategoryDataMapper::toDto);
    }

    /**
     * Delete the crimeCategoryData by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CrimeCategoryData : {}", id);
        crimeCategoryDataRepository.deleteById(id);
    }
}
