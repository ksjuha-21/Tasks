package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.DAO.UserDao;
import security.models.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User entity) {
        this.userDao.save(entity);
    }

    public void delete(User entity) {
        this.userDao.delete(entity);
    }

    public User getByLoginAndPassword(String login, String password_hash) {
        return   this.userDao.getByLoginAndPassword(login, password_hash);
    }

    public  User getUserByLogin (String login) {
        return this.userDao.getUserByLogin(login);
    }
    public User getById(Long id) {
        return  this.userDao.getById(id);
    }

    public void update(User entity) {

        this.userDao.update(entity);
    }

    public boolean listUser(){
       return this.userDao.listUser();
    }

    public UserServiceImpl() {}
}
