package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.DAO.UserDao;
import security.DAO.UserDaoImpl;
import security.models.Role;
import security.models.User;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService = new UserServiceImpl();

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Role role = new Role();
        User user =  userService.getUserByLogin(login);


        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role.getAlias()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword_hash(),
                roles);

        return userDetails;
    }
}
