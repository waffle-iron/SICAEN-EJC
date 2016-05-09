package staLuzia.Sicaen.models;

import staLuzia.Sicaen.util.DAOFactory;

import java.util.List;

/**
 * Created by Henrique on 06/05/2016.
 */
public class EncontristaRepositorio {
    private EncontristaDAO encontristaDAO;

    public EncontristaRepositorio(){
        if(encontristaDAO == null){
            this.encontristaDAO = DAOFactory.createDAO();
        }
    }

    public void add(Encontrista encontrista){
        this.encontristaDAO.save(encontrista);
    }

    public void delete(Encontrista encontrista){
        this.encontristaDAO.delete(encontrista);
    }

    public List<Encontrista> list(){
        return this.encontristaDAO.getAll();
    }

    public void close(){
        if(this.encontristaDAO != null){
            this.encontristaDAO.close();
        }
    }
}
