package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.entityDto.DtUserDto;

public interface UserService {

    DtUserDto findUserById(Long userId);
}
