package com.cerouno.qawadis_api.utility.dtoMapper;

import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.utility.DateTimeHelper;

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
        dto.setDate(DateTimeHelper.toCurrentTimeZone(entity.getDate()));
        dto.setTime(entity.getTime());
        dto.setMaxPlayer(entity.getMaxPlayer());
        dto.setMap(entity.getMap());
        dto.setRemark(entity.getRemark());
        dto.setStatus(LtGeneralStatusMapper.toDto(entity.getStatus(), false));
        dto.setCreatedAt(DateTimeHelper.toCurrentTimeZone(entity.getCreatedAt()));
        dto.setMaintainAt(DateTimeHelper.toCurrentTimeZone(entity.getMaintainAt()));

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
            dto.setDate(DateTimeHelper.toCurrentTimeZone(entity.getDate()));
            dto.setTime(entity.getTime());
            dto.setMaxPlayer(entity.getMaxPlayer());
            dto.setMap(entity.getMap());
            dto.setRemark(entity.getRemark());
            dto.setStatus(LtGeneralStatusMapper.toDto(entity.getStatus(), false));
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
