package com.fms.springsecurity.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.entity.PmoDetails;
@Repository
public interface PmoDetailsRepository extends JpaRepository<PmoDetails, Integer>{

}
