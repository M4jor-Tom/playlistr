package com.theta.playlistr.data.service;

import com.theta.playlistr.domain.Artist;

public interface ArtistDataService extends IDataService<Artist> {
    Artist findByName(String name);
}
