package com.escola.zoomapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escola.zoomapp.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("select p from Post p join p.user u where u.id = :id")
	List<Post> collectionPostUserId(@Param("id") Long id);
}
