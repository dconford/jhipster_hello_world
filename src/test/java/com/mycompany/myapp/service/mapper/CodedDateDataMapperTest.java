package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CodedDateDataMapperTest {

    private CodedDateDataMapper codedDateDataMapper;

    @BeforeEach
    public void setUp() {
        codedDateDataMapper = new CodedDateDataMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(codedDateDataMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(codedDateDataMapper.fromId(null)).isNull();
    }
}
