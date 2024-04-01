package com.theta.playlistr.controller;

import com.theta.playlistr.data.service.PlaylistDataService;
import com.theta.playlistr.domain.Playlist;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    private PlaylistDataService playlistDataService;

    @PostMapping("playlist/create/{playlistName}")
    public void createPlaylist(@PathVariable("playlistName") String playlistName) {

        this.playlistDataService.save(new Playlist().name(playlistName));
    }
}
