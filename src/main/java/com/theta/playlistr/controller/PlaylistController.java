package com.theta.playlistr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theta.playlistr.data.service.ArtistDataService;
import com.theta.playlistr.data.service.PlaylistDataService;
import com.theta.playlistr.data.service.WorkDataService;
import com.theta.playlistr.domain.ArtistContributionToWork;
import com.theta.playlistr.domain.Playlist;
import com.theta.playlistr.domain.Work;
import com.theta.playlistr.knowledge.service.WorkKnowledgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("playlist")
public class PlaylistController {

    private PlaylistDataService playlistDataService;

    private WorkDataService workDataService;

    private ArtistDataService artistDataService;

    private WorkKnowledgeService workKnowledgeService;

    public PlaylistController(PlaylistDataService playlistDataService, WorkKnowledgeService workKnowledgeService, WorkDataService workDataService, ArtistDataService artistDataService) {
        this.playlistDataService = playlistDataService;
        this.workKnowledgeService = workKnowledgeService;
        this.workDataService = workDataService;
        this.artistDataService = artistDataService;
    }

    @GetMapping("get/{playlistName}")
    public Playlist getPlaylist(@PathVariable String playlistName) {

        return this.playlistDataService.findByName(playlistName);
    }

    @PostMapping("create/{playlistName}")
    public void createPlaylist(@PathVariable("playlistName") String playlistName) {

        this.playlistDataService.save(new Playlist().name(playlistName));
    }

    @PutMapping("add-work/{workName}/{resultNumber}/to/{playlistName}")
    public ResponseEntity<String> addWorkToPlaylist(
        @PathVariable String workName,
        @PathVariable int resultNumber,
        @PathVariable String playlistName
    ) {

        Playlist playlist = this.playlistDataService.findByName(playlistName);

        try {

            // Find work with provider
            Work work = this.workKnowledgeService.findByName(workName, resultNumber + 1).get(resultNumber);
            for(ArtistContributionToWork contribution: work.getArtistContributionToWorks()) {

                // If artist does not exist
                // Save it
                this.artistDataService.save(contribution.getAuthor());
            }

            // Save work (cascade save on contribution)
            this.workDataService.save(work);
            playlist.addWork(work);

        } catch (JsonProcessingException e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not fetch works from provider");

        } catch (IndexOutOfBoundsException e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not find that work");
        }

        this.playlistDataService.save(playlist);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
