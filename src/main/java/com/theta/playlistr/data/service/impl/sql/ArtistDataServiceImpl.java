package com.theta.playlistr.data.service.impl.sql;

import com.theta.playlistr.data.repository.ArtistRepository;
import com.theta.playlistr.data.service.ArtistDataService;
import com.theta.playlistr.domain.Artist;
import org.springframework.stereotype.Service;

@Service
public class ArtistDataServiceImpl extends AbstractDataServiceImpl<ArtistRepository, Artist> implements ArtistDataService {
    public ArtistDataServiceImpl(ArtistRepository repository) {
        super(repository);
    }
}
