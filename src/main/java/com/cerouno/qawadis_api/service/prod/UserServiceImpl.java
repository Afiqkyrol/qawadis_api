package com.cerouno.qawadis_api.service.prod;

import com.cerouno.qawadis_api.dto.entityDto.DtUserDto;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.service.UserService;
import com.cerouno.qawadis_api.utility.dtoMapper.DtUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class UserServiceImpl implements UserService {

    @Autowired
    DtUserRepository dtUserRepository;

    @Override
    public DtUserDto findUserById(Integer userId) {
        return DtUserMapper.toDto(dtUserRepository.findByUserId(userId));
    }
}
