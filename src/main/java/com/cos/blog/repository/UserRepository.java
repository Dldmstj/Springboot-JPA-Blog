package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// DAO
// 자동으로 bean 등록이 된다
//@Respository 생략 가능
public interface UserRepository extends JpaRepository<User,Integer> {

}

// JPA naming 쿼리
//SELECT * FROM user WHERE username = ? AND pw = ?;
// User findByUserNameAndPw(String userName, String pw);

//    @Query(value = "SELECT * FROM user WHERE username = ?1 AND pw = ?2", nativeQuery = true)
//    User login(String userName, String pw);