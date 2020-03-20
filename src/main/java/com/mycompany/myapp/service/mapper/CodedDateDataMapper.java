package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CodedDateDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CodedDateData} and its DTO {@link CodedDateDataDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CodedDateDataMapper extends EntityMapper<CodedDateDataDTO, CodedDateData> {


    @Mapping(target = "reportedEvents", ignore = true)
    @Mapping(target = "removeReportedEvents", ignore = true)
    CodedDateData toEntity(CodedDateDataDTO codedDateDataDTO);

    default CodedDateData fromId(Long id) {
        if (id == null) {
            return null;
        }
        CodedDateData codedDateData = new CodedDateData();
        codedDateData.setId(id);
        return codedDateData;
    }
}
