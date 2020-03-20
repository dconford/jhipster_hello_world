package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class NeighborhoodDataDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NeighborhoodDataDTO.class);
        NeighborhoodDataDTO neighborhoodDataDTO1 = new NeighborhoodDataDTO();
        neighborhoodDataDTO1.setId(1L);
        NeighborhoodDataDTO neighborhoodDataDTO2 = new NeighborhoodDataDTO();
        assertThat(neighborhoodDataDTO1).isNotEqualTo(neighborhoodDataDTO2);
        neighborhoodDataDTO2.setId(neighborhoodDataDTO1.getId());
        assertThat(neighborhoodDataDTO1).isEqualTo(neighborhoodDataDTO2);
        neighborhoodDataDTO2.setId(2L);
        assertThat(neighborhoodDataDTO1).isNotEqualTo(neighborhoodDataDTO2);
        neighborhoodDataDTO1.setId(null);
        assertThat(neighborhoodDataDTO1).isNotEqualTo(neighborhoodDataDTO2);
    }
}
