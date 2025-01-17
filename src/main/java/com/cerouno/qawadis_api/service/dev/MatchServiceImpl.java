package com.cerouno.qawadis_api.service.dev;

import com.cerouno.qawadis_api.dto.entity_dto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.service.MatchService;
import com.cerouno.qawadis_api.utility.dto_mapper.DtMatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    DtMatchRepository dtMatchRepository;

    @Override
    public List<DtMatchDto> getMatchListByStatus(Integer status, boolean init) {
        return DtMatchMapper.toDto(dtMatchRepository.findByStatus_statusId(status), init);
    }

}
