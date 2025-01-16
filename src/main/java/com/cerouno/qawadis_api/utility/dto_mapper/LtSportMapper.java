package com.cerouno.qawadis_api.utility.dto_mapper;

import com.cerouno.qawadis_api.dto.entity_dto.LtGeneralStatusDto;
import com.cerouno.qawadis_api.dto.entity_dto.LtSportDto;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LtSportMapper {

    public static LtSportDto toDto(LtSport entity, boolean init) {

        if (entity == null) {
            return null;
        }

        LtSportDto dto = new LtSportDto();
        dto.setSportId(entity.getSportId());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setMaintainAt(entity.getMaintainAt());

        if (init) {
            dto.setCreatedBy(entity.getCreatedBy());
            dto.setMaintainBy(entity.getMaintainBy());
        }

        return dto;
    }

    public static List<LtSportDto> toDto(List<LtSport> entityList, boolean init){

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<LtSportDto> dtoList = new ArrayList<>();

        for (int i = 0; i < entityList.size(); i++) {

            LtSport entity = entityList.get(i);

            LtSportDto dto = new LtSportDto();
            dto.setSportId(entity.getSportId());
            dto.setDescription(entity.getDescription());
            dto.setActive(entity.getActive());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setMaintainAt(entity.getMaintainAt());

            if (init) {
                dto.setCreatedBy(entity.getCreatedBy());
                dto.setMaintainBy(entity.getMaintainBy());
            }

            dtoList.add(dto);
        }

        return dtoList;
    }
}
