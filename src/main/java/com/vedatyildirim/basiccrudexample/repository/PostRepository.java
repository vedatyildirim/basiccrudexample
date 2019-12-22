package com.vedatyildirim.basiccrudexample.repository;

import com.vedatyildirim.basiccrudexample.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}