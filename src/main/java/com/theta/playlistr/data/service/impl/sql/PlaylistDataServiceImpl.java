package com.theta.playlistr.data.service.impl.sql;

import com.theta.playlistr.data.repository.PlaylistRepository;
import com.theta.playlistr.data.service.PlaylistDataService;
import com.theta.playlistr.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistDataServiceImpl extends AbstractDataServiceImpl<PlaylistRepository, Playlist> implements PlaylistDataService {

    public PlaylistDataServiceImpl(PlaylistRepository repository) {
        super(repository);
    }

    @Override
    public Playlist findByName(String name) {
        return this.getRepository().findByName(name);
    }
}
