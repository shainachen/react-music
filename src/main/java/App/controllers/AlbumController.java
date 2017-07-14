package App.controllers;

import App.repositories.AlbumRepository;
import App.domain.Album;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


import javax.annotation.PostConstruct;

@RestController
public class AlbumController {
    private AlbumRepository repository;

    @Autowired
    public AlbumController(AlbumRepository newRepository) {
        this.repository = newRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "React Music";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/albums")
    public Iterable<Album> getAlbums() throws JSONException {
        return repository.findAll();
    }

    @PostConstruct
    public String parseJSON(){
        ClassPathResource filename = new ClassPathResource("AlbumList.csv");
        String cvsSplitBy = ",";
        JSONObject finalAlbums = new JSONObject();
        String data;
        try {
            byte[] albumData = FileCopyUtils.copyToByteArray(filename.getInputStream());
            data = new String(albumData, StandardCharsets.UTF_8);
            JSONArray albumList = new JSONArray();
            String[] rows = data.split("\r\n");
            int counter = 0;
            for(String a: rows) {
                if (counter != 0) {
                    String[] albums = a.split(cvsSplitBy);

                    JSONObject myAlbum = new JSONObject();
                    myAlbum.put("genre", albums[3]);
                    myAlbum.put("year", albums[2]);
                    myAlbum.put("artist", albums[1]);
                    myAlbum.put("name", albums[0]);
                    Album albumInstance = new Album(albums[0], albums[1], albums[2], albums[3]);
                    repository.save(albumInstance);
                    albumList.put(myAlbum);
                }
                counter++;
            }
            finalAlbums.put("albums", albumList);
        }
        catch (IOException e) {
            e.printStackTrace();
            finalAlbums.put("error", "reading file");
        }
        return finalAlbums.toString();
    }
}


