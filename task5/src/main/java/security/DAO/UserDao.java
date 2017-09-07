package security.DAO;


import security.models.User;

public interface UserDao {

    void save(User entity);

     void delete(User entity);

     User getByLoginAndPassword (String login, String password_hash);

     User getUserByLogin(String login);

     User getById(long id);

     void update(User entity);

     boolean listUser();

}
