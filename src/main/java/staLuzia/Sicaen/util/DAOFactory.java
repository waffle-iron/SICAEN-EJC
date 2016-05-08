package staLuzia.Sicaen.util;

import staLuzia.Sicaen.models.EncontristaDAO;
import staLuzia.Sicaen.models.EncontristaDAOHibernate;

/**
 * Created by Henrique on 06/05/2016.
 */
public class DAOFactory {
    static EncontristaDAOHibernate encontristaDAOHibernate = new EncontristaDAOHibernate();

    public static EncontristaDAO createDAO(){
        encontristaDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

        return encontristaDAOHibernate;
    }
}