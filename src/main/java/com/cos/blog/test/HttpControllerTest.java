package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController	// 사용자의 요청에 대해 data로 응답
public class HttpControllerTest {
		
		private static final String TAG = "HttpControllerTest: ";
		
		@GetMapping("/http/lombok")
		public String lombokTest() {
			Member m = Member.builder().userName("eun").pw("5555").eMail("eun").build();
			System.out.println(TAG + "getter:" + m.getUserName());
			m.setUserName("짱구");
			System.out.println(TAG + "getter:" + m.getUserName());
			return "lombokTest";
		}
		
		
		// http://localhost:8080/http/get (select)
		@GetMapping("/http/get")
		public String getTest(Member m) {		// http://localhost:8080/http/get?id=1&userName=eunseo
			return "get 요청 : " + m.getId() + " , " +m.getUserName() ;
		}
		
		// http://localhost:8080/http/post (insert)
		@PostMapping("/http/post")
		public String postTest(@RequestBody Member m) {
			return "post 요청 : " + m.getId() + " , " + m.getUserName() + " , " + m.getPw() + " , " + m.getEMail();
		}
		
		// http://localhost:8080/http/put (update)
		@PutMapping("/http/put")
		public String putTest(@RequestBody Member m) {
			return "put 요청 : " + m.getId() + " , " + m.getPw();
		}
		
		// http://localhost:8080/http/delete (delete)
		@DeleteMapping("/http/delete")
		public String deleteTest() {
			return "delete 요청";
		}
		
		// 인터넷 브라우저 요청은 get 요청밖에 할 수 없음
}
