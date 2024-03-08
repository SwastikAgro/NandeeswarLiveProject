package com.jsp.AgroProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.AgroProject.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
