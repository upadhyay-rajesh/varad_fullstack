package com.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.entity.VaradFacebookEntity;

@Repository
public interface FacebookDAOInterface extends JpaRepository<VaradFacebookEntity, String>{

}
