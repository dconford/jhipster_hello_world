package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ReportedEventsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReportedEvents} and its DTO {@link ReportedEventsDTO}.
 */
@Mapper(componentModel = "spring", uses = {CrimeCategoryDataMapper.class, NeighborhoodDataMapper.class, CodedDateDataMapper.class})
public interface ReportedEventsMapper extends EntityMapper<ReportedEventsDTO, ReportedEvents> {

    @Mapping(source = "crimeCategoryData.id", target = "crimeCategoryDataId")
    @Mapping(source = "neighborhoodData.id", target = "neighborhoodDataId")
    @Mapping(source = "codedDateData.id", target = "codedDateDataId")
    ReportedEventsDTO toDto(ReportedEvents reportedEvents);

    @Mapping(source = "crimeCategoryDataId", target = "crimeCategoryData")
    @Mapping(source = "neighborhoodDataId", target = "neighborhoodData")
    @Mapping(source = "codedDateDataId", target = "codedDateData")
    ReportedEvents toEntity(ReportedEventsDTO reportedEventsDTO);

    default ReportedEvents fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReportedEvents reportedEvents = new ReportedEvents();
        reportedEvents.setId(id);
        return reportedEvents;
    }
}
