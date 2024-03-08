package com.jsp.AgroProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.AgroProject.entity.Image;

public interface Imagerepo extends JpaRepository<Image, Integer> {

}
