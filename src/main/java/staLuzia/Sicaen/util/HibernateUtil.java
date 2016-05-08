package staLuzia.Sicaen.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Henrique on 06/05/2016.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    private static SessionFactory buildSessionFactory(){
        try{
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
            registradorServico.applySettings(cfg.getProperties());
            StandardServiceRegistry servico = registradorServico.build();

            return cfg.buildSessionFactory(servico);

        }catch(Exception e){
            System.out.println("Criação do objeto SessionFactory falhou. Erro: "+e);
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}