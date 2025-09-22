package com.cerouno.qawadis_api.utility.dtoMapper;

import com.cerouno.qawadis_api.dto.entityDto.DtUserDto;
import com.cerouno.qawadis_api.entity.DtUser;

public class DtUserMapper {

    public static DtUserDto toDto (DtUser entity){

        if(entity == null){
            return null;
        }

        DtUserDto dto = new DtUserDto();
        dto.setUserId(entity.getUserId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
