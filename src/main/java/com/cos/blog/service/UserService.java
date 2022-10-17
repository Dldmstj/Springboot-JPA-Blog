package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public int save(User user) {
        String rawPassword = user.getPw(); // 1234 원문
        String encPassword = encoder.encode(rawPassword); // 해쉬
        user.setPw(encPassword);
        user.setRole(RoleType.USER);
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            return -1;
        }

    }

        // 회원수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit 이 자동으로 됩니다.
        // 영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update문을 날려줌.
    }


   /* @Transactional(readOnly = true)     // Select할 때 트랜잭션 시작, 서비스 종료시 트랜잭션 종료
    public User login(User user) {
        return userRepository.findByUserNameAndPw(user.getUserName(), user.getPw());
    }*/

