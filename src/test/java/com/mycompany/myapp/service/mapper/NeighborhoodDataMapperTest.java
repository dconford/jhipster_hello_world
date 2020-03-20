package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NeighborhoodDataMapperTest {

    private NeighborhoodDataMapper neighborhoodDataMapper;

    @BeforeEach
    public void setUp() {
        neighborhoodDataMapper = new NeighborhoodDataMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(neighborhoodDataMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(neighborhoodDataMapper.fromId(null)).isNull();
    }
}
