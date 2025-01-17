package com.cerouno.qawadis_api.utility.dto_mapper;

import com.cerouno.qawadis_api.dto.entity_dto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;

public class DtMatchMapper {

    public static DtMatchDto toDto(DtMatch entity, boolean init){

        DtMatchDto dto = new DtMatchDto();
        dto.setMatchId(entity.getMatchId());
        dto.setSport(LtSportMapper.toDto(entity.getSport(), true));
        dto.setVenue(entity.getVenue());
        dto.setAddress(entity.getAddress());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setMap(entity.getMap());
        dto.setRemark(entity.getRemark());
        dto.setStatus(LtGeneralStatusMapper.toDto(entity.getStatus(), true));
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setMaintainAt(entity.getMaintainAt());

        if(init){
            dto.setCreatedBy(DtUserMapper.toDto(entity.getCreatedBy()));
            dto.setMaintainBy(DtUserMapper.toDto(entity.getMaintainBy()));
        }

        return dto;
    }
}
