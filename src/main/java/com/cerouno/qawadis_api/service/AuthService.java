package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.LoginDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.entity.DtUser;

public interface AuthService {

    String login (RequestDto<LoginDto> request);

    String register (RequestDto<DtUser> request);

    Integer resetPassword(RequestDto<DtUser> request);
}
