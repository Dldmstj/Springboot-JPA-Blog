<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form>
        <div class="form-group">
            <label for="userName">userName:</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="userName">
        </div>

        <div class="form-group">
            <label for="pw">Password:</label>
            <input type="password" class="form-control" placeholder="Enter Password" id="pw">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" placeholder="Enter Email" id="email">
        </div>

    </form>

    <button id="btn-save" class="btn btn-primary"> 회원가입 완료 </button>

</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>



