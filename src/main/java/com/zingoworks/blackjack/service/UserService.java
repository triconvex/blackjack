package com.zingoworks.blackjack.service;

import com.zingoworks.blackjack.domain.player.User;
import com.zingoworks.blackjack.domain.player.UserRepository;
import com.zingoworks.blackjack.exception.NotFoundUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NotFoundUserException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll(Sort.by(DESC, "chip"));
    }

    public int getRank(User loginUser, List<User> allUsers) {
        int rank = 0;
        for (User user : allUsers) {
            rank++;
            if (loginUser.equals(user)) {
                break;
            }
        }
        return rank;
    }

    public User login(String userId, String password) throws NotFoundUserException {
        return userRepository.findByUserId(userId)
                .filter(user -> user.isVerified(password))
                .orElseThrow(NotFoundUserException::new);
    }
//
//    public User update(User loginUser, long id, User updatedUser) {
//        User original = findByUserId(loginUser, id);
//        original.update(loginUser, updatedUser);
//        return userRepository.save(original);
//    }
}
