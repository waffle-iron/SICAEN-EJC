package staLuzia.Sicaen.util;

import staLuzia.Sicaen.models.encontrista.EncontristaDAO;
import staLuzia.Sicaen.models.encontrista.EncontristaDAOHibernate;

/**
 * Created by Henrique on 06/05/2016.
 */
public class DAOFactory {
    static EncontristaDAOHibernate encontristaDAOHibernate = new EncontristaDAOHibernate();

    public static EncontristaDAO createDAO(){
        encontristaDAOHibernate.setSession(HibernateUtil.getSessionFactory().openSession());

        return encontristaDAOHibernate;
    }
}