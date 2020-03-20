package com.mycompany.myapp.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.NeighborhoodData} entity.
 */
public class NeighborhoodDataDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer neighborhoodId;

    private String neighborhoodName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Integer neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NeighborhoodDataDTO neighborhoodDataDTO = (NeighborhoodDataDTO) o;
        if (neighborhoodDataDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), neighborhoodDataDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NeighborhoodDataDTO{" +
            "id=" + getId() +
            ", neighborhoodId=" + getNeighborhoodId() +
            ", neighborhoodName='" + getNeighborhoodName() + "'" +
            "}";
    }
}
