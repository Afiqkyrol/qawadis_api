package com.cerouno.qawadis_api.utility.dto_mapper;

import com.cerouno.qawadis_api.dto.entity_dto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DtMatchMapper {

    public static DtMatchDto toDto(DtMatch entity, boolean init){

        DtMatchDto dto = new DtMatchDto();
        dto.setMatchId(entity.getMatchId());
        dto.setSport(LtSportMapper.toDto(entity.getSport(), false));
        dto.setVenue(entity.getVenue());
        dto.setAddress(entity.getAddress());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setMap(entity.getMap());
        dto.setRemark(entity.getRemark());
        dto.setStatus(LtGeneralStatusMapper.toDto(entity.getStatus(), false));
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setMaintainAt(entity.getMaintainAt());

        if(init){
            if(entity.getCreatedBy() != null){
                dto.setCreatedBy(DtUserMapper.toDto(entity.getCreatedBy()));
            }
            if(entity.getMaintainBy() != null){
                dto.setMaintainBy(DtUserMapper.toDto(entity.getMaintainBy()));
            }
        }

        return dto;
    }

    public static List<DtMatchDto> toDto(List<DtMatch> entityList, boolean init){

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<DtMatchDto> dtoList = new ArrayList<>();

        for (DtMatch entity : entityList) {

            DtMatchDto dto = new DtMatchDto();
            dto.setMatchId(entity.getMatchId());
            dto.setSport(LtSportMapper.toDto(entity.getSport(), false));
            dto.setVenue(entity.getVenue());
            dto.setAddress(entity.getAddress());
            dto.setDate(entity.getDate());
            dto.setTime(entity.getTime());
            dto.setMap(entity.getMap());
            dto.setRemark(entity.getRemark());
            dto.setStatus(LtGeneralStatusMapper.toDto(entity.getStatus(), false));
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
