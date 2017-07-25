package App.domain;
import javax.persistence.*;

@Entity
public class Albums {
    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    @Column(name = "year")
    private String year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public Albums() {}


    public Albums(String name, String artist, String year, String genre) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
