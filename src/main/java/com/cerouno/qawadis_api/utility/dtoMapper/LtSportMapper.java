package com.cerouno.qawadis_api.utility.dtoMapper;

import com.cerouno.qawadis_api.dto.entityDto.LtSportDto;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.utility.DateTimeHelper;

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
        dto.setCreatedAt(DateTimeHelper.toCurrentTimeZone(entity.getCreatedAt()));
        dto.setMaintainAt(DateTimeHelper.toCurrentTimeZone(entity.getMaintainAt()));

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

    public static List<LtSportDto> toDto(List<LtSport> entityList, boolean init){

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<LtSportDto> dtoList = new ArrayList<>();

        for (LtSport entity : entityList) {

            LtSportDto dto = new LtSportDto();
            dto.setSportId(entity.getSportId());
            dto.setDescription(entity.getDescription());
            dto.setActive(entity.getActive());
            dto.setCreatedAt(DateTimeHelper.toCurrentTimeZone(entity.getCreatedAt()));
            dto.setMaintainAt(DateTimeHelper.toCurrentTimeZone(entity.getMaintainAt()));

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
