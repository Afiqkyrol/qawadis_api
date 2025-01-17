package com.cerouno.qawadis_api.utility.dto_mapper;

import com.cerouno.qawadis_api.dto.entity_dto.DtUserDto;
import com.cerouno.qawadis_api.entity.DtUser;

public class DtUserMapper {

    public static DtUserDto toDto (DtUser entity){
        DtUserDto dto = new DtUserDto();
        dto.setUserId(entity.getUserId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
