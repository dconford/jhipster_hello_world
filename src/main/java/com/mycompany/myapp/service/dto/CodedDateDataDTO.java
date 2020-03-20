package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CodedDateData} entity.
 */
public class CodedDateDataDTO implements Serializable {

    private Long id;

    private Integer codedDate;

    private String codedDateString;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodedDate() {
        return codedDate;
    }

    public void setCodedDate(Integer codedDate) {
        this.codedDate = codedDate;
    }

    public String getCodedDateString() {
        return codedDateString;
    }

    public void setCodedDateString(String codedDateString) {
        this.codedDateString = codedDateString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CodedDateDataDTO codedDateDataDTO = (CodedDateDataDTO) o;
        if (codedDateDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), codedDateDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CodedDateDataDTO{" +
            "id=" + getId() +
            ", codedDate=" + getCodedDate() +
            ", codedDateString='" + getCodedDateString() + "'" +
            "}";
    }
}
