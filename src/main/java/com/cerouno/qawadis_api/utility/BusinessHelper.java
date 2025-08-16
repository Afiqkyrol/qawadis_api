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

    public void validateUserMatchCriteria(MtUserMatch userMatch, MtUserMatchRepository mtUserMatchRepository, Integer userId){

        if(!userMatch.getGame().getStatus().getStatusId().equals(AppConstants.GSTS_ACTIVE))
            throw new BusinessException(HttpStatus.BAD_REQUEST, "The Match Status is "+userMatch.getGame().getStatus().getCode());

        if(userMatch.getUserMatchId() == null){
            Integer currNum = mtUserMatchRepository.countByGame_matchIdAndStatus_statusId(userMatch.getGame().getMatchId(), AppConstants.GSTS_ACTIVE);
            if(mtUserMatchRepository.findByGame_matchIdAndStatus_statusIdAndPlayer_userId(userMatch.getGame().getMatchId(), AppConstants.GSTS_ACTIVE, userId) != null)
                throw new BusinessException(HttpStatus.CONFLICT, "User already joined");
            if(currNum >= userMatch.getGame().getMaxPlayer())
                throw new BusinessException(HttpStatus.CONFLICT, "The match is full, currently there are " + currNum + " player(s)");

        }else{
            MtUserMatch mtUserMatch = mtUserMatchRepository.findByUserMatchId(userMatch.getUserMatchId());
            if(!mtUserMatch.getStatus().getStatusId().equals(AppConstants.GSTS_ACTIVE))
                throw new BusinessException(HttpStatus.FORBIDDEN, "Cannot update, current status is not active");
            if(!Objects.equals(userId, mtUserMatch.getPlayer().getUserId())){
                throw new BusinessException(HttpStatus.FORBIDDEN, "Cannot update other player join details");
            }
        }

    }
}
