package App;

import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import static App.Application.AlbumJSON;

@RestController
public class AlbumController {



    @RequestMapping("/")
    public String index() {
        return "React Music";
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/albums")
    public String getAlbums() throws JSONException {
        return AlbumJSON;
    }
}


