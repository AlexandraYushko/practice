package org.example.application.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.adapter.repository.UserRepositoryAdapter;
import org.example.application.api.service.UserService;
import org.example.domain.User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositoryAdapter userRepository;

    @Override
    public User create(User user) {
        log.info("Создаём пользователя! Делаем какую-то бизнес-логику =)");
        return userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        try {
            log.info("Информация о пользователе!");
            return userRepository.get(uuid);
        } catch (Exception e) {
            log.info("Такого пользователя не существует!");
            throw e;
        }
    }

    @Override
    public User update(User user) {
        try {
            log.info("Обновляем данные пользователя!");
            return userRepository.update(user);
        } catch (Exception e) {
            log.info("Такого пользователя не существует!");
            throw e;
        }
    }

    @Override
    public void delete(String uuid) {
        log.info("Удаляем пользователя!");
        userRepository.delete(uuid);
    }
}
