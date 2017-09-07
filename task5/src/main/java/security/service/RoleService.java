package security.service;

import security.models.Role;

public interface RoleService {

    void save(Role entity);

    void delete(Role entity);

    Role getByAlias (String alias);

    Role getById(long id);

    void update(Role entity);

    boolean listRoles();
}
