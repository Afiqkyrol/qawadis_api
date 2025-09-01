package com.cerouno.qawadis_api.utility.dtoMapper;

import com.cerouno.qawadis_api.dto.entityDto.MtUserMatchDto;
import com.cerouno.qawadis_api.entity.MtUserMatch;
import com.cerouno.qawadis_api.utility.DateTimeHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MtUserMatchMapper {

    public static MtUserMatchDto toDto(MtUserMatch entity, boolean init){

        MtUserMatchDto dto = new MtUserMatchDto();
        dto.setUserMatchId(entity.getUserMatchId());
        dto.setGame(DtMatchMapper.toDto(entity.getGame(), false));
        dto.setPlayer(DtUserMapper.toDto(entity.getPlayer()));
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

    public static List<MtUserMatchDto> toDto(List<MtUserMatch> entityList, boolean init){

        if (entityList.isEmpty()) {
            return Collections.emptyList();
        }

        List<MtUserMatchDto> dtoList = new ArrayList<>();

        for (MtUserMatch entity : entityList) {

            MtUserMatchDto dto = new MtUserMatchDto();
            dto.setUserMatchId(entity.getUserMatchId());
            dto.setGame(DtMatchMapper.toDto(entity.getGame(), false));
            dto.setPlayer(DtUserMapper.toDto(entity.getPlayer()));
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
