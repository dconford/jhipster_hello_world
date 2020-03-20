package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class CrimeCategoryDataDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CrimeCategoryDataDTO.class);
        CrimeCategoryDataDTO crimeCategoryDataDTO1 = new CrimeCategoryDataDTO();
        crimeCategoryDataDTO1.setId(1L);
        CrimeCategoryDataDTO crimeCategoryDataDTO2 = new CrimeCategoryDataDTO();
        assertThat(crimeCategoryDataDTO1).isNotEqualTo(crimeCategoryDataDTO2);
        crimeCategoryDataDTO2.setId(crimeCategoryDataDTO1.getId());
        assertThat(crimeCategoryDataDTO1).isEqualTo(crimeCategoryDataDTO2);
        crimeCategoryDataDTO2.setId(2L);
        assertThat(crimeCategoryDataDTO1).isNotEqualTo(crimeCategoryDataDTO2);
        crimeCategoryDataDTO1.setId(null);
        assertThat(crimeCategoryDataDTO1).isNotEqualTo(crimeCategoryDataDTO2);
    }
}
