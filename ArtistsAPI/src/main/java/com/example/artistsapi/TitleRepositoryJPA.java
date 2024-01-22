package com.example.artistsapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitleRepositoryJPA extends JpaRepository<Title, Long> {
    @Query("select t from Title t where t.title like :name" + "%")
    List<Title> findTitleByName(@Param("name") String name);
}
