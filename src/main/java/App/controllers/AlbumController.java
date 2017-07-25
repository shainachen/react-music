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
    private AlbumRepository repository;

    @Autowired
    public AlbumController(AlbumRepository newRepository) {
        this.repository = newRepository;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Albums> getAlbums() throws JSONException {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        repository.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Albums add(@RequestBody @Valid String album) {
        JSONObject albumJSON = new JSONObject(album);
        Albums newAlbum = new Albums(albumJSON.getString("name"), albumJSON.getString("artist"), albumJSON.getString("year"), albumJSON.getString("genre"));
        return repository.save(newAlbum);
    }

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


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Albums getById(@PathVariable String id) {
        return repository.findOne(id);
    }
//
//    @PostConstruct
//    public void readMySQLDB(){
//        String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_d9a5414dd4e200a?autoReconnect=true&useSSL=false";
//        String username = "b38e5b3b31c75a";
//        String password = "fde06131";
//
//        System.out.println("Connecting database...");
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//            Statement st = connection.createStatement();
//            String sql = ("SELECT * FROM albums;");
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()) {
//                String name = rs.getString("name");
//                String artist = rs.getString("artist");
//                String year = rs.getString("year");
//                String genre = rs.getString("genre");
//                Albums albumInstance = new Albums(name, artist, year, genre);
//                repository.save(albumInstance);
//            }
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    @PostConstruct
//    public void parseJSON(){
//        ClassPathResource filename = new ClassPathResource("AlbumList.csv");
//        String cvsSplitBy = ",";
//        String data;
//        try {
//            byte[] albumData = FileCopyUtils.copyToByteArray(filename.getInputStream());
//            data = new String(albumData, StandardCharsets.UTF_8);
//            String[] rows = data.split("\r\n");
//            int counter = 0;
//            for(String a: rows) {
//                if (counter != 0) {
//                    String[] albums = a.split(cvsSplitBy);
//                    Albums albumInstance = new Albums(albums[0], albums[1], albums[2], albums[3]);
//                    repository.save(albumInstance);
//                }
//                counter++;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
////    @PostConstruct
////    public String parseJSON(){
////        ClassPathResource filename = new ClassPathResource("AlbumList.csv");
////        String cvsSplitBy = ",";
////        JSONObject finalAlbums = new JSONObject();
////        String data;
////        try {
////            byte[] albumData = FileCopyUtils.copyToByteArray(filename.getInputStream());
////            data = new String(albumData, StandardCharsets.UTF_8);
////            JSONArray albumList = new JSONArray();
////            String[] rows = data.split("\r\n");
////            int counter = 0;
////            for(String a: rows) {
////                if (counter != 0) {
////                    String[] albums = a.split(cvsSplitBy);
////
////                    JSONObject myAlbum = new JSONObject();
////                    myAlbum.put("genre", albums[3]);
////                    myAlbum.put("year", albums[2]);
////                    myAlbum.put("artist", albums[1]);
////                    myAlbum.put("name", albums[0]);
////                    Albums albumInstance = new Albums(albums[0], albums[1], albums[2], albums[3]);
////                    repository.save(albumInstance);
////                    albumList.put(myAlbum);
////                }
////                counter++;
////            }
////            finalAlbums.put("albums", albumList);
////        }
////        catch (IOException e) {
////            e.printStackTrace();
////            finalAlbums.put("error", "reading file");
////        }
////        return finalAlbums.toString();
////    }
}


