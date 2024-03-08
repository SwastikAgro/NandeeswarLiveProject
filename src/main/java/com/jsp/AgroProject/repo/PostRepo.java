package com.jsp.AgroProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.AgroProject.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
