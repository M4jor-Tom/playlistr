package com.theta.playlistr.data.service;

import com.theta.playlistr.domain.Playlist;

public interface PlaylistDataService extends IDataService<Playlist> {

    Playlist findByName(String name);
}
