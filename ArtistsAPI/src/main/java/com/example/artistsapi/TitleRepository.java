package com.example.artistsapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TitleRepository  extends CrudRepository<Title, Long>{
    Optional<Title> findById(Long id); // w kazdym repo: getById, getAll, getByName(title)


}
