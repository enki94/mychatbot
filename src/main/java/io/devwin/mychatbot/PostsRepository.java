package io.devwin.mychatbot;

import org.springframework.data.jpa.repository.JpaRepository;

import io.devwin.mychatbot.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>{
}
