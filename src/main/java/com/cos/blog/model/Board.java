package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob		// longtext
	private String Content;	// 섬머노트 라이브러리 사용 <html>태그가 섞여서 디자인됨
	
	@ColumnDefault("0")	// 초기 기본값 0
	private int count;	// 조회수
	
	@ManyToOne		// Many = Board, One = User
	@JoinColumn(name="userId")
	private User user;	// DB는 오브젝트를 저장할 수 없다(FK), 자바는 오브젝트를 저장할 수 있음.
	
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER)  
	// board와 연관관계를 가지고 있음. 속성 생성 x, FK 생성 x
	// @JoinColumn 필요없음, 1정규형 위반. 하나의 속성값에 여러 값이 들어갈 수 없음
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;		// 작성 시간
}
