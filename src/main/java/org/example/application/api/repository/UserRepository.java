package org.example.application.api.repository;

import org.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
