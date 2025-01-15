package com.cerouno.qawadis_api.utility.dto_mapper;

import com.cerouno.qawadis_api.dto.entity_dto.LtGeneralStatusDto;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LtGeneralStatusMapper {
    public static LtGeneralStatusDto toDto(LtGeneralStatus entity, boolean init) {
        if (entity == null) {
            return null;
        }

        LtGeneralStatusDto dto = new LtGeneralStatusDto();
        dto.setStatusId(entity.getStatusId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setMaintainAt(entity.getMaintainAt());

        if(init){
            dto.setCreatedBy(entity.getCreatedBy());
            dto.setMaintainBy(entity.getMaintainBy());
        }

        return dto;
    }

    public static List<LtGeneralStatusDto> toDto(List<LtGeneralStatus> entityList, boolean init) {
        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<LtGeneralStatusDto> dtoList = new ArrayList<>();

        for(int i = 0; i<entityList.size(); i++){

            LtGeneralStatus entity = entityList.get(i);

            LtGeneralStatusDto dto = new LtGeneralStatusDto();
            dto.setStatusId(entity.getStatusId());
            dto.setCode(entity.getCode());
            dto.setDescription(entity.getDescription());
            dto.setActive(entity.getActive());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setMaintainAt(entity.getMaintainAt());

            if(init){
                dto.setCreatedBy(entity.getCreatedBy());
                dto.setMaintainBy(entity.getMaintainBy());
            }

            dtoList.add(dto);
        }



        return dtoList;
    }
}
