package com.example.artistsapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Artist findByName(String name);

    //Artist findByName(String name);
    ///rtist findByTitle(String title);
}
