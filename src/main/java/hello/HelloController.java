package hello;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController

public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/albums")
    public String index1() throws JSONException {
        String filename = "lib/AlbumList.csv";
        String line = "";
        String cvsSplitBy = ",";
        JSONObject finalAlbums = new JSONObject();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            JSONArray albumList = new JSONArray();

            int counter = 0;

            while ((line = br.readLine()) != null) {

                if (counter != 0) {

                    // use comma as separator
                    String[] albums = line.split(cvsSplitBy);

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


            //System.out.print(finalAlbums);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalAlbums.toString();

    }
}
