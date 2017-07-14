package App.repositories;

import App.domain.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, String> {
    Album findByArtist(String artist);
    List<Album> findByGenre(String genre);
}
