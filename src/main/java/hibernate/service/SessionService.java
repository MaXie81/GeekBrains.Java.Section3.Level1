package hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class SessionService {
    private SessionFactory sessionFactory;
    private Session session;

    public SessionService() {
        this.sessionFactory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public Session getSession() {
        return session;
    }

    @PreDestroy
    public void preDestroy() {
        session.close();
        sessionFactory.close();
    }
}
