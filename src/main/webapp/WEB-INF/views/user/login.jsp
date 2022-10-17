<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form action="#" method="post">
        <div class="form-group">
            <label for="userName">userName:</label>
            <input type="text" name="userName" class="form-control" placeholder="Enter Username" id="userName">
        </div>

        <div class="form-group">
            <label for="pw">Password:</label>
            <input type="password" name="pw" class="form-control" placeholder="Enter Password" id="pw">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input name="remember" class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <button id="btn-login" class="btn btn-primary"> 로그인 </button>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>



