package com.cerouno.qawadis_api.service.prod;

import com.cerouno.qawadis_api.dto.LoginDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.entity.DtUser;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.security.JwtSecurity;
import com.cerouno.qawadis_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class AuthServiceImpl implements AuthService {

    private final DtUserRepository dtUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(DtUserRepository dtUserRepository, BCryptPasswordEncoder passwordEncoder) {
        this.dtUserRepository = dtUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(RequestDto<LoginDto> request) {
        DtUser dtUser = dtUserRepository.findByEmail(request.getBody().getEmail())
                .orElseThrow(() -> new AuthorizationDeniedException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getBody().getPassword(), dtUser.getPassword())) {
            throw new AuthorizationDeniedException("Invalid email or password");
        }

        return JwtSecurity.generateToken(dtUser.getUserId());
    }

    public String register(RequestDto<DtUser> request) {

        if (dtUserRepository.existsByEmail(request.getBody().getEmail())) {
            throw new RuntimeException("Email is already in use.");
        }

        request.getBody().setPassword(passwordEncoder.encode(request.getBody().getPassword()));

        return JwtSecurity.generateToken( dtUserRepository.save(request.getBody()).getUserId());
    }
}
