package com.cerouno.qawadis_api.utility;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.entity.MtUserMatch;
import com.cerouno.qawadis_api.exception.BusinessException;
import com.cerouno.qawadis_api.repository.MtUserMatchRepository;
import org.springframework.http.HttpStatus;

public class BusinessHelper {

    public boolean validateJoinCriteria(MtUserMatch userMatch, MtUserMatchRepository mtUserMatchRepository){

        if(!userMatch.getGame().getStatus().getStatusId().equals(AppConstants.GSTS_ACTIVE))
            throw new BusinessException(HttpStatus.BAD_REQUEST, "The Match Status is "+userMatch.getGame().getStatus().getCode());

        Integer currNum = mtUserMatchRepository.countByGame_matchIdAndStatus_statusId(userMatch.getGame().getMatchId(), AppConstants.GSTS_ACTIVE);
        if(currNum >= userMatch.getGame().getMaxPlayer())
            throw new BusinessException(HttpStatus.CONFLICT, "The match is full, currently there are " + currNum + " player(s)");

        return true;
    }
}
