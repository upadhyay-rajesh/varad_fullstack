package com.facebookspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facebookspringboot.entity.FacebookUser;

@Repository
public interface FacebookDAOInterface extends JpaRepository<FacebookUser, String>{
	@Query("from com.facebookspringboot.entity.FacebookUser f where f.email=:em and f.password=:pw")
	public FacebookUser loginDAO(@Param("em")  String userid, @Param("pw")String password);
}
