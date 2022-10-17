<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <label for="userName">Username</label>
            <input type="text" name="userName" class="form-control" placeholder="Enter username" id="userName">
        </div>

        <div class="form-group">
            <label for="pw">Password</label>
            <input type="password" name="pw" class="form-control" placeholder="Enter password" id="pw">
        </div>

        <button id="btn-login" class="btn btn-primary">로그인</button>
    </form>

</div>

<%@ include file="../layout/footer.jsp"%>



