package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.NeighborhoodDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NeighborhoodData} and its DTO {@link NeighborhoodDataDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NeighborhoodDataMapper extends EntityMapper<NeighborhoodDataDTO, NeighborhoodData> {


    @Mapping(target = "reportedEvents", ignore = true)
    @Mapping(target = "removeReportedEvents", ignore = true)
    NeighborhoodData toEntity(NeighborhoodDataDTO neighborhoodDataDTO);

    default NeighborhoodData fromId(Long id) {
        if (id == null) {
            return null;
        }
        NeighborhoodData neighborhoodData = new NeighborhoodData();
        neighborhoodData.setId(id);
        return neighborhoodData;
    }
}
