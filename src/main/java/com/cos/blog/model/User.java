package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity		// User 클래스 MySQL에 테이블 생성
// @DynamicInsert // insert시에 null인 필드를 제외
public class User {
	
	@Id		// PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	// 프로젝트에서 연결된 DB의 넘버링 전략을 따라감. MySQL 은 Auto
	private int id;		// auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String userName;		// 아이디, 중복 x
	
	@Column(nullable = false, length = 500)		// hash로 비밀번호 암호화
	private String pw;		// 비밀번호
	
	@Column(nullable = false, length = 50)
	private String email;

	// DB에는 RoleType X
	// @ColumnDefault("user")
	@Enumerated(EnumType.STRING)
	private RoleType role;		// 도메인을 사용할 수 있는 Enum을 사용하는게 좋음
	
	@CreationTimestamp		// 시간이 자동으로 입력됨
	private Timestamp createDate;		// 가입일,시간
	
}
