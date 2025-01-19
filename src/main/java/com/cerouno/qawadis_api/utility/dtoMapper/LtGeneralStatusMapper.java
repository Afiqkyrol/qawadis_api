package com.cerouno.qawadis_api.utility.dtoMapper;

import com.cerouno.qawadis_api.dto.entityDto.LtGeneralStatusDto;
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

        if (init) {
            if(entity.getCreatedBy() != null){
                dto.setCreatedBy(DtUserMapper.toDto(entity.getCreatedBy()));
            }
            if(entity.getMaintainBy() != null){
                dto.setMaintainBy(DtUserMapper.toDto(entity.getMaintainBy()));
            }
        }

        return dto;
    }

    public static List<LtGeneralStatusDto> toDto(List<LtGeneralStatus> entityList, boolean init) {

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<LtGeneralStatusDto> dtoList = new ArrayList<>();

        for (LtGeneralStatus entity : entityList) {

            LtGeneralStatusDto dto = new LtGeneralStatusDto();
            dto.setStatusId(entity.getStatusId());
            dto.setCode(entity.getCode());
            dto.setDescription(entity.getDescription());
            dto.setActive(entity.getActive());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setMaintainAt(entity.getMaintainAt());

            if (init) {
                if(entity.getCreatedBy() != null){
                    dto.setCreatedBy(DtUserMapper.toDto(entity.getCreatedBy()));
                }
                if(entity.getMaintainBy() != null){
                    dto.setMaintainBy(DtUserMapper.toDto(entity.getMaintainBy()));
                }
            }

            dtoList.add(dto);
        }

        return dtoList;
    }
}
