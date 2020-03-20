package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterHelloWorldApp;
import com.mycompany.myapp.domain.CrimeCategoryData;
import com.mycompany.myapp.repository.CrimeCategoryDataRepository;
import com.mycompany.myapp.service.CrimeCategoryDataService;
import com.mycompany.myapp.service.dto.CrimeCategoryDataDTO;
import com.mycompany.myapp.service.mapper.CrimeCategoryDataMapper;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.mycompany.myapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CrimeCategoryDataResource} REST controller.
 */
@SpringBootTest(classes = JhipsterHelloWorldApp.class)
public class CrimeCategoryDataResourceIT {

    private static final Integer DEFAULT_CRIME_CATEGORY_ID = 1;
    private static final Integer UPDATED_CRIME_CATEGORY_ID = 2;

    private static final String DEFAULT_CRIME_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_CRIME_CATEGORY = "BBBBBBBBBB";

    @Autowired
    private CrimeCategoryDataRepository crimeCategoryDataRepository;

    @Autowired
    private CrimeCategoryDataMapper crimeCategoryDataMapper;

    @Autowired
    private CrimeCategoryDataService crimeCategoryDataService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restCrimeCategoryDataMockMvc;

    private CrimeCategoryData crimeCategoryData;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CrimeCategoryDataResource crimeCategoryDataResource = new CrimeCategoryDataResource(crimeCategoryDataService);
        this.restCrimeCategoryDataMockMvc = MockMvcBuilders.standaloneSetup(crimeCategoryDataResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CrimeCategoryData createEntity(EntityManager em) {
        CrimeCategoryData crimeCategoryData = new CrimeCategoryData()
            .crimeCategoryId(DEFAULT_CRIME_CATEGORY_ID)
            .crimeCategory(DEFAULT_CRIME_CATEGORY);
        return crimeCategoryData;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CrimeCategoryData createUpdatedEntity(EntityManager em) {
        CrimeCategoryData crimeCategoryData = new CrimeCategoryData()
            .crimeCategoryId(UPDATED_CRIME_CATEGORY_ID)
            .crimeCategory(UPDATED_CRIME_CATEGORY);
        return crimeCategoryData;
    }

    @BeforeEach
    public void initTest() {
        crimeCategoryData = createEntity(em);
    }

    @Test
    @Transactional
    public void createCrimeCategoryData() throws Exception {
        int databaseSizeBeforeCreate = crimeCategoryDataRepository.findAll().size();

        // Create the CrimeCategoryData
        CrimeCategoryDataDTO crimeCategoryDataDTO = crimeCategoryDataMapper.toDto(crimeCategoryData);
        restCrimeCategoryDataMockMvc.perform(post("/api/crime-category-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(crimeCategoryDataDTO)))
            .andExpect(status().isCreated());

        // Validate the CrimeCategoryData in the database
        List<CrimeCategoryData> crimeCategoryDataList = crimeCategoryDataRepository.findAll();
        assertThat(crimeCategoryDataList).hasSize(databaseSizeBeforeCreate + 1);
        CrimeCategoryData testCrimeCategoryData = crimeCategoryDataList.get(crimeCategoryDataList.size() - 1);
        assertThat(testCrimeCategoryData.getCrimeCategoryId()).isEqualTo(DEFAULT_CRIME_CATEGORY_ID);
        assertThat(testCrimeCategoryData.getCrimeCategory()).isEqualTo(DEFAULT_CRIME_CATEGORY);
    }

    @Test
    @Transactional
    public void createCrimeCategoryDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = crimeCategoryDataRepository.findAll().size();

        // Create the CrimeCategoryData with an existing ID
        crimeCategoryData.setId(1L);
        CrimeCategoryDataDTO crimeCategoryDataDTO = crimeCategoryDataMapper.toDto(crimeCategoryData);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCrimeCategoryDataMockMvc.perform(post("/api/crime-category-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(crimeCategoryDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CrimeCategoryData in the database
        List<CrimeCategoryData> crimeCategoryDataList = crimeCategoryDataRepository.findAll();
        assertThat(crimeCategoryDataList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkCrimeCategoryIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = crimeCategoryDataRepository.findAll().size();
        // set the field null
        crimeCategoryData.setCrimeCategoryId(null);

        // Create the CrimeCategoryData, which fails.
        CrimeCategoryDataDTO crimeCategoryDataDTO = crimeCategoryDataMapper.toDto(crimeCategoryData);

        restCrimeCategoryDataMockMvc.perform(post("/api/crime-category-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(crimeCategoryDataDTO)))
            .andExpect(status().isBadRequest());

        List<CrimeCategoryData> crimeCategoryDataList = crimeCategoryDataRepository.findAll();
        assertThat(crimeCategoryDataList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCrimeCategoryData() throws Exception {
        // Initialize the database
        crimeCategoryDataRepository.saveAndFlush(crimeCategoryData);

        // Get all the crimeCategoryDataList
        restCrimeCategoryDataMockMvc.perform(get("/api/crime-category-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(crimeCategoryData.getId().intValue())))
            .andExpect(jsonPath("$.[*].crimeCategoryId").value(hasItem(DEFAULT_CRIME_CATEGORY_ID)))
            .andExpect(jsonPath("$.[*].crimeCategory").value(hasItem(DEFAULT_CRIME_CATEGORY)));
    }
    
    @Test
    @Transactional
    public void getCrimeCategoryData() throws Exception {
        // Initialize the database
        crimeCategoryDataRepository.saveAndFlush(crimeCategoryData);

        // Get the crimeCategoryData
        restCrimeCategoryDataMockMvc.perform(get("/api/crime-category-data/{id}", crimeCategoryData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(crimeCategoryData.getId().intValue()))
            .andExpect(jsonPath("$.crimeCategoryId").value(DEFAULT_CRIME_CATEGORY_ID))
            .andExpect(jsonPath("$.crimeCategory").value(DEFAULT_CRIME_CATEGORY));
    }

    @Test
    @Transactional
    public void getNonExistingCrimeCategoryData() throws Exception {
        // Get the crimeCategoryData
        restCrimeCategoryDataMockMvc.perform(get("/api/crime-category-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCrimeCategoryData() throws Exception {
        // Initialize the database
        crimeCategoryDataRepository.saveAndFlush(crimeCategoryData);

        int databaseSizeBeforeUpdate = crimeCategoryDataRepository.findAll().size();

        // Update the crimeCategoryData
        CrimeCategoryData updatedCrimeCategoryData = crimeCategoryDataRepository.findById(crimeCategoryData.getId()).get();
        // Disconnect from session so that the updates on updatedCrimeCategoryData are not directly saved in db
        em.detach(updatedCrimeCategoryData);
        updatedCrimeCategoryData
            .crimeCategoryId(UPDATED_CRIME_CATEGORY_ID)
            .crimeCategory(UPDATED_CRIME_CATEGORY);
        CrimeCategoryDataDTO crimeCategoryDataDTO = crimeCategoryDataMapper.toDto(updatedCrimeCategoryData);

        restCrimeCategoryDataMockMvc.perform(put("/api/crime-category-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(crimeCategoryDataDTO)))
            .andExpect(status().isOk());

        // Validate the CrimeCategoryData in the database
        List<CrimeCategoryData> crimeCategoryDataList = crimeCategoryDataRepository.findAll();
        assertThat(crimeCategoryDataList).hasSize(databaseSizeBeforeUpdate);
        CrimeCategoryData testCrimeCategoryData = crimeCategoryDataList.get(crimeCategoryDataList.size() - 1);
        assertThat(testCrimeCategoryData.getCrimeCategoryId()).isEqualTo(UPDATED_CRIME_CATEGORY_ID);
        assertThat(testCrimeCategoryData.getCrimeCategory()).isEqualTo(UPDATED_CRIME_CATEGORY);
    }

    @Test
    @Transactional
    public void updateNonExistingCrimeCategoryData() throws Exception {
        int databaseSizeBeforeUpdate = crimeCategoryDataRepository.findAll().size();

        // Create the CrimeCategoryData
        CrimeCategoryDataDTO crimeCategoryDataDTO = crimeCategoryDataMapper.toDto(crimeCategoryData);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCrimeCategoryDataMockMvc.perform(put("/api/crime-category-data")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(crimeCategoryDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CrimeCategoryData in the database
        List<CrimeCategoryData> crimeCategoryDataList = crimeCategoryDataRepository.findAll();
        assertThat(crimeCategoryDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCrimeCategoryData() throws Exception {
        // Initialize the database
        crimeCategoryDataRepository.saveAndFlush(crimeCategoryData);

        int databaseSizeBeforeDelete = crimeCategoryDataRepository.findAll().size();

        // Delete the crimeCategoryData
        restCrimeCategoryDataMockMvc.perform(delete("/api/crime-category-data/{id}", crimeCategoryData.getId())
            .accept(TestUtil.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CrimeCategoryData> crimeCategoryDataList = crimeCategoryDataRepository.findAll();
        assertThat(crimeCategoryDataList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
