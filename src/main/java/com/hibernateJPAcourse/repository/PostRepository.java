package com.hibernateJPAcourse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hibernateJPAcourse.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer>{

}
