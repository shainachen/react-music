package App.repositories;

import App.domain.Albums;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Albums, String> {
    Albums findByArtist(String artist);
    List<Albums> findByGenre(String genre);
}
