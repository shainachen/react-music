package App.controllers;

import App.domain.Albums;
import App.repositories.AlbumRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {
    public static AlbumRepository repository;
    @Autowired
    public AlbumController(AlbumRepository newRepository) {
        this.repository = newRepository;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Albums> getAlbums() throws JSONException {
        return repository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        repository.delete(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public Albums add(@RequestBody @Valid String album) {
        JSONObject albumJSON = new JSONObject(album);
        Albums newAlbum = new Albums(albumJSON.getString("name"), albumJSON.getString("artist"), albumJSON.getString("year"), albumJSON.getString("genre"));
        return repository.save(newAlbum);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Albums update(@PathVariable String id, @RequestBody @Valid String album) {
        JSONObject albumJSON = new JSONObject(album);
        Albums updatedAlbum = new Albums(albumJSON.getString("name"), albumJSON.getString("artist"), albumJSON.getString("year"), albumJSON.getString("genre"));
        Albums albumToUpdate = repository.findOne(id);
        albumToUpdate.setName(updatedAlbum.getName());
        albumToUpdate.setYear(updatedAlbum.getYear());
        albumToUpdate.setGenre(updatedAlbum.getGenre());
        albumToUpdate.setArtist(updatedAlbum.getArtist());
        return repository.save(albumToUpdate);
    }


    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Albums getById(@PathVariable String id) {
        return repository.findOne(id);
    }
}


