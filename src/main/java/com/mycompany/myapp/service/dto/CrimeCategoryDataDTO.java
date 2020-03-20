package com.mycompany.myapp.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.CrimeCategoryData} entity.
 */
public class CrimeCategoryDataDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer crimeCategoryId;

    private String crimeCategory;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCrimeCategoryId() {
        return crimeCategoryId;
    }

    public void setCrimeCategoryId(Integer crimeCategoryId) {
        this.crimeCategoryId = crimeCategoryId;
    }

    public String getCrimeCategory() {
        return crimeCategory;
    }

    public void setCrimeCategory(String crimeCategory) {
        this.crimeCategory = crimeCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CrimeCategoryDataDTO crimeCategoryDataDTO = (CrimeCategoryDataDTO) o;
        if (crimeCategoryDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), crimeCategoryDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CrimeCategoryDataDTO{" +
            "id=" + getId() +
            ", crimeCategoryId=" + getCrimeCategoryId() +
            ", crimeCategory='" + getCrimeCategory() + "'" +
            "}";
    }
}
