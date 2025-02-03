package com.example.demo.repository;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    //Blog --> Entity
    //Long --> Entity내의 id로 지정한 컬럼의 타입
    //Entity는 항상 @Id를 꼭 가지고 있어야함.(JPA)
    //insert할 때 pk인 id가 없으면 insert함. 이미 있으면 자동으로  update함.


    @Query("select count(b) from Blog b")
    long totalCount();

    @Query("select count(b) from Blog b where b.blogId >= 3")
    long up3();

    @Query("select b from Blog b where b.content2 like concat('%', '행복', '%')")
    List<Blog> findHappy();

    @Query("select b.content from Blog b where b.blogId = 1")
    String findByBlogId1();

    @Query("select b.content from Blog b where b.blogId = 2")
    String findByBlogId2();

    @Query("select b from Blog b where b.blogId = 3")
    Blog findByBlogId3();
}