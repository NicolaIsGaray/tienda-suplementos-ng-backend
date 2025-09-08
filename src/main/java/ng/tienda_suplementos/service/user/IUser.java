package ng.tienda_suplementos.service.user;


import ng.tienda_suplementos.model.User;

public interface IUser {
    User saveUser(User user);
    User searchUserById(String id);
    void deleteUser(String id);
}
