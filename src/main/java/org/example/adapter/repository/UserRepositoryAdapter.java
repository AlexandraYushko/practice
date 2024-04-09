package org.example.adapter.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.application.api.repository.UserRepository;
import org.example.domain.User;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter { // TODO: spring data
    private final UserRepository jpaRepository;

    public User save(User user) {
        user = jpaRepository.save(user);
        return user;
    }

    public User get(String uuid) {
        return jpaRepository.findByUuid(uuid);
    }

    public User update(User user) {
        return jpaRepository.save(user);
    }

    //@Override
    public void delete(String uuid) {
        jpaRepository.deleteByUuid(uuid);
    }
}
