package in.tilaksolunke.billingsoftware.service;

import in.tilaksolunke.billingsoftware.io.UserRequest;
import in.tilaksolunke.billingsoftware.io.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    String getUserRole(String email);
    List<UserResponse> readUsers();
    void deleteUser(String id);
}
