package com.theta.playlistr.data.repository;

import com.theta.playlistr.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findByName(String name);
}
