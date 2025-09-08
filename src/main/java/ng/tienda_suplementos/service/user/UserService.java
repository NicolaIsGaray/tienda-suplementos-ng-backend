package ng.tienda_suplementos.service.user;

import ng.tienda_suplementos.model.User;
import ng.tienda_suplementos.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUser{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User searchUserById(String id) {
         return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
