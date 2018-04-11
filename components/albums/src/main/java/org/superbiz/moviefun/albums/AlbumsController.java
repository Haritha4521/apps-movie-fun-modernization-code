package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
class AlbumsController {

    private final AlbumsRepository albumsRepository;

    AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }

    @GetMapping
    public List<Album> index() {
        return albumsRepository.getAlbums();
    }

    @GetMapping("/{albumId}")
    public Album details(@PathVariable Long albumId) {
        return albumsRepository.find(albumId);
    }
}