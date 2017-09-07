package security.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private Session session;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {

        session = sessionFactory.getCurrentSession();
        return session;
    }

    public void save(User user) {
        getSession().save(user);
        return;
    }

    public void delete(User user) {
        session.close();
        getSession().delete(user);
        return;
    }

    public User getByLoginAndPassword (String login, String password_hash) {
        return (User) getSession().createQuery("from User where login = :login and password_hash = :password_hash")
                .setParameter("login", login).setParameter("password_hash", password_hash)
                .uniqueResult();
    }


    public User getById(long id) {
        return  (User) getSession().load(User.class, id);
    }

    public User getUserByLogin(String login) {
        return (User) getSession().createQuery("from User where login = :login")
                .setParameter("login", login)
                .uniqueResult();
    }

    public void update(User user) {
        getSession().update(user);
        return;
    }

    @SuppressWarnings("unchecked")
    public boolean listUser() {
        List<User> users = getSession().createQuery("from User").list();
        if (users.size()==0) {
            return true;
        } else {
            return false; }

          }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
