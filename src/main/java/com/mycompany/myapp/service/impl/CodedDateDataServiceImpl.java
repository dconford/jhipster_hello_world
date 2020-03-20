package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.CodedDateDataService;
import com.mycompany.myapp.domain.CodedDateData;
import com.mycompany.myapp.repository.CodedDateDataRepository;
import com.mycompany.myapp.service.dto.CodedDateDataDTO;
import com.mycompany.myapp.service.mapper.CodedDateDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link CodedDateData}.
 */
@Service
@Transactional
public class CodedDateDataServiceImpl implements CodedDateDataService {

    private final Logger log = LoggerFactory.getLogger(CodedDateDataServiceImpl.class);

    private final CodedDateDataRepository codedDateDataRepository;

    private final CodedDateDataMapper codedDateDataMapper;

    public CodedDateDataServiceImpl(CodedDateDataRepository codedDateDataRepository, CodedDateDataMapper codedDateDataMapper) {
        this.codedDateDataRepository = codedDateDataRepository;
        this.codedDateDataMapper = codedDateDataMapper;
    }

    /**
     * Save a codedDateData.
     *
     * @param codedDateDataDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CodedDateDataDTO save(CodedDateDataDTO codedDateDataDTO) {
        log.debug("Request to save CodedDateData : {}", codedDateDataDTO);
        CodedDateData codedDateData = codedDateDataMapper.toEntity(codedDateDataDTO);
        codedDateData = codedDateDataRepository.save(codedDateData);
        return codedDateDataMapper.toDto(codedDateData);
    }

    /**
     * Get all the codedDateData.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CodedDateDataDTO> findAll() {
        log.debug("Request to get all CodedDateData");
        return codedDateDataRepository.findAll().stream()
            .map(codedDateDataMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one codedDateData by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CodedDateDataDTO> findOne(Long id) {
        log.debug("Request to get CodedDateData : {}", id);
        return codedDateDataRepository.findById(id)
            .map(codedDateDataMapper::toDto);
    }

    /**
     * Delete the codedDateData by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CodedDateData : {}", id);
        codedDateDataRepository.deleteById(id);
    }
}
