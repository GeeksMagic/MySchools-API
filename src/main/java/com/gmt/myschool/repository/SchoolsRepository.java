package com.gmt.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmt.myschool.dao.SchoolDao;

public interface SchoolsRepository extends JpaRepository<SchoolDao, Long> {

}
