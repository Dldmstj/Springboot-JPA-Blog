package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {
    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String deleteUser(@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "해당 아이디가 없습니다. 삭제 실패";
        }
        return "삭제되었습니다 id: " + id;
    }

    // pw, email 수정
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        System.out.println("id: " + id);
        System.out.println("pw: " + requestUser.getPw());
        System.out.println("email: " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정 실패");
        });     // DB에서 user를 받아옴 (예외처리)
        user.setPw(requestUser.getPw());
        user.setEmail(requestUser.getEmail());

        // userRepository.save(user);
        return null;
    }

    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    // 페이지당 2건의 데이터를 리턴받는 메소드
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
       List<User> users =  userRepository.findAll(pageable).getContent();
       return users;
    }

    // {id} 주소로 파라미터를 전달받을 수 있음
    // http://localhost:8000/blog/dummy/user/1
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저가 존재하지 않습니다. id : " + id);
            }
        });
        return user;
    }

    //http://localhost:8000/blog/dummy/join (요청)
    //http의 body에 username, pw, email 데이터를 가지고 요청하면 세 값이 파라미터에 들어감
    @PostMapping("/dummy/join")
    public String join(User user) {      // key = value
        System.out.println("id: " + user.getId());
        System.out.println("username: " +user.getUserName());
        System.out.println("pw: " +user.getPw());
        System.out.println("email: " +user.getEmail());
        System.out.println("role: " +user.getRole());
        System.out.println("createDate: " +user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
