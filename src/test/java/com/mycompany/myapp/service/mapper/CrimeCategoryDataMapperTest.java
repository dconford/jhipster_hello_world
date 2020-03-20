package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CrimeCategoryDataMapperTest {

    private CrimeCategoryDataMapper crimeCategoryDataMapper;

    @BeforeEach
    public void setUp() {
        crimeCategoryDataMapper = new CrimeCategoryDataMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(crimeCategoryDataMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(crimeCategoryDataMapper.fromId(null)).isNull();
    }
}
