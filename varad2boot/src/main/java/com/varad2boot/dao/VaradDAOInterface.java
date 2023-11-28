package com.varad2boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varad2boot.entity.FacebookVarad;

@Repository
public interface VaradDAOInterface extends JpaRepository<FacebookVarad, String>{

}
