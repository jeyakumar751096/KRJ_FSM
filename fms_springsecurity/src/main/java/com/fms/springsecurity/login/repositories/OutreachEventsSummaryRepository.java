package com.fms.springsecurity.login.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.OutreachEventsSummary;

@Repository
public interface OutreachEventsSummaryRepository extends PagingAndSortingRepository<OutreachEventsSummary, Integer>{

}
