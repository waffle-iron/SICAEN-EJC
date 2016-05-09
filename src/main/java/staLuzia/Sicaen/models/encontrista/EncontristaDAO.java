package staLuzia.Sicaen.models.encontrista;

import java.util.List;

/**
 * Created by Henrique on 06/05/2016.
 */
public interface EncontristaDAO {

    public void save(Encontrista encontrista);

    public void delete(Encontrista encontrista);

    public List<Encontrista> getAll();

    public void close();
}