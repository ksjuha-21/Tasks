package security.service;

import security.models.User;

public interface UserService {

    void save(User entity);

    void delete(User entity);

    User getByLoginAndPassword (String login, String password_hash);

    User getUserByLogin(String login);
    User getById(Long id);

    void update(User entity);

    boolean listUser();
}
