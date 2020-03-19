package com.fms.springsecurity.login.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.OutReachEventInformation;

@Repository
public interface OutReachEventInformationRepository extends JpaRepository<OutReachEventInformation, Integer>{
	
	List<OutReachEventInformation> findAll();
	
	@Query(value = "select sum(livesImpacted) from outreacheventinformation", nativeQuery=true)
	Integer toltalLivesImpact();

}
