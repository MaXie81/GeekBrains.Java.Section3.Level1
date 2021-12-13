package hibernate.service;

import hibernate.dto.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDao implements IEntityDao<Client> {
    private SessionService sessionService;
    private Session session;
    private Transaction transaction;

    public ClientDao(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public Client findById(Long id) {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        Client client = session.find(Client.class, id);
        transaction.commit();
        session.close();

        return client;
    }

    @Override
    public List<Client> findAll() {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        List<Client> productList = session
                .createQuery("SELECT p FROM Client p", Client.class)
                .getResultList();
        transaction.commit();
        session.close();

        return productList;
    }

    @Override
    public void deleteById(Long id) {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        Client client = session.find(Client.class, id);
        session.delete(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client saveOrUpdate(Client client) {
        session = sessionService.getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(client);
        transaction.commit();
        session.close();

        return client;
    }
}
