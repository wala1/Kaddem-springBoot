package tn.esprit.kaddemspringbootproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.repositories.IRoleDao;
import tn.esprit.kaddemspringbootproject.repositories.IUserDao;

import javax.transaction.Transactional;
import java.util.List;


@Service @RequiredArgsConstructor @Slf4j @Transactional
public class UserServices implements IUserServices{

    private final IUserDao iUserDao ;
    private final IRoleDao iRoleDao ;

    @Override
    public User saveUser(User user) {
        return iUserDao.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return iRoleDao.save(role);
    }

    @Override
    public void affectRoleToUser(Integer idUser, Integer idRole) {
        User user = iUserDao.findById(idUser).orElse(null);
        Role role = iRoleDao.findById(idRole).orElse(null);
        role.setUser(user);
    }


    @Override
    public void addUserAddRoleWithAffect(User user) {
        iUserDao.save(user);
        user.getRoles().forEach(r -> r.setUser(user));

    }

    @Override
    public User addUserAssignToRole(User user, Integer idRole) {

        iUserDao.save(user);
        Role r = iRoleDao.findById(idRole).orElse(null);
        r.setUser(user);
        return user;
    }

    @Override
    public User getUser(Integer idUser) {
        return iUserDao.findById(idUser).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
