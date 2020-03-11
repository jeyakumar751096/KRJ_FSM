package com.fms.springsecurity.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fms.springsecurity.login.enumtype.AuthorityType;

import lombok.Data;

@Entity
@Table(name = "Authority")
@Data
public class Authority {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorityId")
    private Integer authorityId;

    @Enumerated(EnumType.STRING)
    private AuthorityType authorityName;
}
