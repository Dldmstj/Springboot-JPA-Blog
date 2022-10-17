package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service    // 스프링이 컴포넌트 스캔을 통해 bean에 등록
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

   /* @Transactional(readOnly = true)     // Select할 때 트랜잭션 시작, 서비스 종료시 트랜잭션 종료
    public User login(User user) {
        return userRepository.findByUserNameAndPw(user.getUserName(), user.getPw());
    }*/
}
