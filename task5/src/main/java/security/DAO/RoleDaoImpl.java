package security.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.models.Role;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    private Session session;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {

        session = sessionFactory.getCurrentSession();
        return session;

    }

    public void save(Role role) {
        getSession().save(role);
        return;
    }

    public void delete(Role role) {
        session.close();
        getSession().delete(role);
        return;
    }

    public Role getByAlias(String alias) {
        return (Role) getSession().createQuery("from Role where alias = :alias")
                .setParameter("alias", alias)
                .uniqueResult();
    }

    public Role getById(long id) {
        return  (Role) getSession().load(Role.class, id);
    }

    public void update(Role role) {
        getSession().update(role);
        return;
    }

    @SuppressWarnings("unchecked")
    public boolean listRoles() {
        List<Role> roles = getSession().createQuery("from Role").list();
        if (roles.size()==0) {
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
