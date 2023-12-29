<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../../includes/header.jsp"%>
<style>
    #pagination li {
        display: inline
    }
    #pagination li a {
        display: inline-block;
        text-decoration: none;
        padding: 5px 10px;
        color: #000
    }

    /* Active and Hoverable Pagination */
    #pagination li a {
        border-radius: 5px;
        -webkit-transition: background-color 0.3s;
        transition: background-color 0.3s

    }
    #pagination li a.active {
        background-color: #4caf50;
        color: #fff
    }
    #pagination li a:hover:not(.active) {
        background-color: #ddd;
    }

    /* border-pagination */
    .b-pagination-outer {
        width: 100%;
        margin: 0 auto;
        text-align: center;
        overflow: hidden;
        display: flex
    }
    #border-pagination {
        margin: 0 auto;
        padding: 0;
        text-align: center
    }
    #border-pagination li {
        display: inline;

    }
    #border-pagination li a {
        display: block;
        text-decoration: none;
        color: #000;
        padding: 5px 10px;
        border: 1px solid #ddd;
        float: left;

    }
    #border-pagination li a {
        -webkit-transition: background-color 0.4s;
        transition: background-color 0.4s
    }
    #border-pagination li a.active {
        background-color: #4caf50;
        color: #fff;
    }
    #border-pagination li a:hover:not(.active) {
        background: #ddd;
    }

    .list-div:hover {
        cursor: pointer;
    }
</style>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">News 관리</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">News 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th style="width: 10%;">번호</th>
                                            <th style="width: 55%;">제목</th>
                                            <th style="width: 10%;">작성자</th>
                                            <th style="width: 25%;">작성일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${not empty NEWS_LIST.content}">
                                        <c:forEach var="list" items="${NEWS_LIST.content}">
                                            <tr class="list-div" onclick="goDetail(${list.newsNo})">
                                                <td>${list.newsNo}</td>
                                                <td>${list.title}</td>
                                                <td>${list.regAdminName}</td>
                                                <td>${list.regDt}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    </tbody>
                                </table>
                            </div>

                            <div class="my-2"></div>
                            <a href="/news/regist" class="btn btn-secondary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-right"></i>
                                        </span>
                                <span class="text">글쓰기</span>
                            </a>

                            <div id="wrapper">
                                <div class="b-pagination-outer">
                                    <ul id="border-pagination">
                                        <li><a class="" href="<c:url value="?page=0" />">«</a></li>
                                        <c:forEach var="i" begin="${START_PAGE-1}" end="${END_PAGE - 1}">
                                            <c:choose>
                                                <c:when test="${NEWS_LIST.number eq i}">
                                                    <li><a href="<c:url value="?page=1" />" class="active">${i + 1}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li><a href="<c:url value="?page=${i}" />">${i + 1}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li><a href="<c:url value="?page=${NEWS_LIST.totalPages-1}" />">»</a></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </div>


                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->

<%@include file="../../includes/footer.jsp"%>

<script>
    function goDetail(no){
        var pageUrl='/news/detail/'+no;
        window.location.href = pageUrl;
    }
</script>