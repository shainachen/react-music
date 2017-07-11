package App;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class AlbumController {



    @RequestMapping("/")
    public String index() {
        return "React Music";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/albums")
    public String getAlbums() throws JSONException {
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


