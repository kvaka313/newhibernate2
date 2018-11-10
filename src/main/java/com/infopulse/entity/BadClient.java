package com.infopulse.entity;

import com.infopulse.entity.Client;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
//@DiscriminatorValue("BADCLIENT")
public class BadClient extends Client {

    @Column(name = "expired_black_list")
    private Date expiredBlackList = new Date();
}