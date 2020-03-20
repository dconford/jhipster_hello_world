package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class CodedDateDataDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CodedDateDataDTO.class);
        CodedDateDataDTO codedDateDataDTO1 = new CodedDateDataDTO();
        codedDateDataDTO1.setId(1L);
        CodedDateDataDTO codedDateDataDTO2 = new CodedDateDataDTO();
        assertThat(codedDateDataDTO1).isNotEqualTo(codedDateDataDTO2);
        codedDateDataDTO2.setId(codedDateDataDTO1.getId());
        assertThat(codedDateDataDTO1).isEqualTo(codedDateDataDTO2);
        codedDateDataDTO2.setId(2L);
        assertThat(codedDateDataDTO1).isNotEqualTo(codedDateDataDTO2);
        codedDateDataDTO1.setId(null);
        assertThat(codedDateDataDTO1).isNotEqualTo(codedDateDataDTO2);
    }
}
