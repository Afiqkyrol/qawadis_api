package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.entityDto.DtUserDto;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.utility.dtoMapper.DtUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DtUserRepository dtUserRepository;

    @Override
    public DtUserDto findUserById(Long userId) {
        return DtUserMapper.toDto(dtUserRepository.findByUserId(userId));
    }
}
