package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReportedEventsMapperTest {

    private ReportedEventsMapper reportedEventsMapper;

    @BeforeEach
    public void setUp() {
        reportedEventsMapper = new ReportedEventsMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(reportedEventsMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(reportedEventsMapper.fromId(null)).isNull();
    }
}
