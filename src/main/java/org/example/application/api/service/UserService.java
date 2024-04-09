package org.example.application.api.service;

import org.example.domain.User;

public interface UserService {
    User create(User user);
    User get (String uuid);
    User update (User user);
    void delete (String uuid);
}
