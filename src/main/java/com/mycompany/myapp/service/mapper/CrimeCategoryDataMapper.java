package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CrimeCategoryDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CrimeCategoryData} and its DTO {@link CrimeCategoryDataDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CrimeCategoryDataMapper extends EntityMapper<CrimeCategoryDataDTO, CrimeCategoryData> {


    @Mapping(target = "reportedEvents", ignore = true)
    @Mapping(target = "removeReportedEvents", ignore = true)
    CrimeCategoryData toEntity(CrimeCategoryDataDTO crimeCategoryDataDTO);

    default CrimeCategoryData fromId(Long id) {
        if (id == null) {
            return null;
        }
        CrimeCategoryData crimeCategoryData = new CrimeCategoryData();
        crimeCategoryData.setId(id);
        return crimeCategoryData;
    }
}
