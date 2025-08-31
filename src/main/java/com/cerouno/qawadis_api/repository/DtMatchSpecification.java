package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.DtUser;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;

public class DtMatchSpecification {

    public static Specification<DtMatch> hasSport(Integer sportId) {
        return (root, query, cb) -> sportId == null ? null :
                cb.equal(root.get("sport").get("sportId"), sportId);
    }

    public static Specification<DtMatch> hasVenue(String venue) {
        return (root, query, cb) -> (venue == null || venue.isBlank()) ? null :
                cb.like(cb.lower(root.get("venue")), "%" + venue.toLowerCase() + "%");
    }

    public static Specification<DtMatch> hasDate(LocalDate date) {
        return (root, query, cb) -> date == null ? null :
                cb.equal(root.get("date"), date);
    }

    public static Specification<DtMatch> hasTime(LocalTime time) {
        return (root, query, cb) -> time == null ? null :
                cb.equal(root.get("time"), time);
    }

    public static Specification<DtMatch> hasStatus(Integer statusId) {
        return (root, query, cb) -> statusId == null ? null :
                cb.equal(root.get("status").get("statusId"), statusId);
    }

    public static Specification<DtMatch> createdBy(Integer userId) {
        return (root, query, cb) -> userId == null ? null :
                cb.equal(root.get("createdBy").get("userId"), userId);
    }

}
