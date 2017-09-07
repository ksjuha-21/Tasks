package security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.DAO.RoleDao;
import security.models.Role;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void save(Role entity) {
        this.roleDao.save(entity);

    }

    @Override
    public void delete(Role entity) {
        this.roleDao.delete(entity);
    }

    @Override
    public Role getByAlias(String alias) {
        return this.roleDao.getByAlias(alias);
    }

    @Override
    public Role getById(long id) {
        return this.roleDao.getById(id);
    }

    @Override
    public void update(Role entity) {

        this.roleDao.update(entity);
    }

    @Override
    public boolean listRoles() {
        return this.roleDao.listRoles();
    }
}
