package staLuzia.Sicaen.models.encontrista;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Henrique on 06/05/2016.
 */
public class EncontristaDAOHibernate implements EncontristaDAO{
    private Session session;
    private Transaction transaction;

    public void setSession(Session session){
        this.session = session;
        this.transaction = session.beginTransaction();
    }

    public void save(Encontrista encontrista) {
        this.session.save(encontrista);
        this.transaction.commit();

    }

    public void delete(Encontrista encontrista) {
        this.session.delete(encontrista);
        this.transaction.commit();

    }

    public List<Encontrista> getAll() {
        List<Encontrista> list = this.session.createCriteria(Encontrista.class).list();

        if(!list.isEmpty()){

            return list;
        }
        return null;
    }

    public void close(){
        if(this.session != null){
            this.session.close();
        }
    }

}
