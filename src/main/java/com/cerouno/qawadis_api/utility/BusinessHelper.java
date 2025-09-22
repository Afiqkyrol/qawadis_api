package com.cerouno.qawadis_api.utility;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.entity.MtUserMatch;
import com.cerouno.qawadis_api.exception.BusinessException;
import com.cerouno.qawadis_api.repository.MtUserMatchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BusinessHelper {

    public void validateUserMatchCriteria(MtUserMatch userMatch, MtUserMatchRepository mtUserMatchRepository, Long userId){

        if(!userMatch.getGame().getStatus().getStatusId().equals(AppConstants.GSTS_ACTIVE.longValue()))
            throw new BusinessException(HttpStatus.BAD_REQUEST, "The Match Status is "+userMatch.getGame().getStatus().getCode());

        if(userMatch.getUserMatchId() == null){
            Long currNum = mtUserMatchRepository.countByGame_matchIdAndStatus_statusId(userMatch.getGame().getMatchId(), AppConstants.GSTS_ACTIVE.longValue());
            if(mtUserMatchRepository.findByGame_matchIdAndStatus_statusIdAndPlayer_userId(userMatch.getGame().getMatchId(), AppConstants.GSTS_ACTIVE.longValue(), userId) != null)
                throw new BusinessException(HttpStatus.CONFLICT, "User already joined");
            if(currNum != null && currNum >= userMatch.getGame().getMaxPlayer())
                throw new BusinessException(HttpStatus.CONFLICT, "The match is full, currently there are " + currNum + " player(s)");

        }else{
            MtUserMatch mtUserMatch = mtUserMatchRepository.findByUserMatchId(userMatch.getUserMatchId());
            if(mtUserMatch != null && !userId.equals(mtUserMatch.getPlayer().getUserId())){
                throw new BusinessException(HttpStatus.FORBIDDEN, "Cannot update other player join details");
            }
        }

    }
}
