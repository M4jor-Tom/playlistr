package com.theta.playlistr.data.repository;

import com.theta.playlistr.domain.Playlist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @EntityGraph(value = "Playlist.works")
    Playlist findByName(String name);
}
