package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class NeighborhoodDataTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NeighborhoodData.class);
        NeighborhoodData neighborhoodData1 = new NeighborhoodData();
        neighborhoodData1.setId(1L);
        NeighborhoodData neighborhoodData2 = new NeighborhoodData();
        neighborhoodData2.setId(neighborhoodData1.getId());
        assertThat(neighborhoodData1).isEqualTo(neighborhoodData2);
        neighborhoodData2.setId(2L);
        assertThat(neighborhoodData1).isNotEqualTo(neighborhoodData2);
        neighborhoodData1.setId(null);
        assertThat(neighborhoodData1).isNotEqualTo(neighborhoodData2);
    }
}
