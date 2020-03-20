package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class ReportedEventsDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReportedEventsDTO.class);
        ReportedEventsDTO reportedEventsDTO1 = new ReportedEventsDTO();
        reportedEventsDTO1.setId(1L);
        ReportedEventsDTO reportedEventsDTO2 = new ReportedEventsDTO();
        assertThat(reportedEventsDTO1).isNotEqualTo(reportedEventsDTO2);
        reportedEventsDTO2.setId(reportedEventsDTO1.getId());
        assertThat(reportedEventsDTO1).isEqualTo(reportedEventsDTO2);
        reportedEventsDTO2.setId(2L);
        assertThat(reportedEventsDTO1).isNotEqualTo(reportedEventsDTO2);
        reportedEventsDTO1.setId(null);
        assertThat(reportedEventsDTO1).isNotEqualTo(reportedEventsDTO2);
    }
}
