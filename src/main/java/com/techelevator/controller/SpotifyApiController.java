package com.techelevator.controller;

import com.techelevator.domain.spotify.SpotifyTokenResponse;
import com.techelevator.services.SpotifyApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController
@CrossOrigin
public class SpotifyApiController {

    private SpotifyApiService spotifyApiService;

    public SpotifyApiController(SpotifyApiService spotifyApiService) {
        this.spotifyApiService = spotifyApiService;
    }

    @GetMapping("/receive-token")
    @ResponseBody
    public ResponseEntity<Void> processAccessCode(@RequestParam String code, HttpServletResponse httpServletResponse) {
        SpotifyTokenResponse response = spotifyApiService.getToken(code);
        if (response != null) {
//            httpServletResponse.setHeader("Location", "http://localhost:8080/landing");
//            httpServletResponse.setStatus(302);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://mypartylist.s3-website-us-east-1.amazonaws.com/landing")).build();

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


    }

}
