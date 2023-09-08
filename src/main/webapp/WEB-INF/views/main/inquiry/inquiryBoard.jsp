<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../../includes/header.jsp"%>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Inquiry Board 관리 </h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Inquiry Board 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">

                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>이름</th>
                                            <th>작성일</th>
                                        </tr>
                                    </thead>

                                    <tbody>

<c:forEach var="inquiry" items="${INQUIRY_LIST}" varStatus="vs">
    <tr onclick="location.href='/inquiryDetail/${inquiry.inquiryNo}'" style="cursor: pointer">
        <th scope="row">${inquiry.inquiryNo}</th>
        <td>${inquiry.title}</td>
        <td>홍길동</td>
        <td>${inquiry.regDt}</td>
    </tr>
    <c:if test="${not empty inquiry.replies}">
        <c:forEach var="replies" items="${inquiry.replies}" >
            <tr>
                <td>-</td>
                <td><i class="fa-solid fa-arrow-turn-down-right"></i> Re : ${replies.contents}</td>
                <td>관리자</td>
                <td>2023/03/01</td>
            </tr>
        </c:forEach>
    </c:if>
</c:forEach>
                                        <tr onclick="location.href='/inquiryDetail/5'" style="cursor: pointer">
                                            <th scope="row">5</th>
                                            <td>비공개</td>
                                            <td>김기*</td>
                                            <td>2023/03/06</td>
                                        </tr>
                                        <tr onclick="location.href='/inquiryDetail/4'" style="cursor: pointer">
                                            <th scope="row">4</th>
                                            <td>비공개</td>
                                            <td>이제*</td>
                                            <td>2023/03/04</td>
                                        </tr>
                                        <tr onclick="location.href='/inquiryDetail/3'" style="cursor: pointer">
                                            <th scope="row">2</th>
                                            <td>비공개</td>
                                            <td>김은*</td>
                                            <td>2023/03/02</td>
                                        </tr>
                                        <tr>
                                            <td>-</td>
                                            <td><i class="fa-solid fa-arrow-turn-down-right"></i> Re : 비공개</td>
                                            <td>관리자</td>
                                            <td>2023/03/02</td>
                                        </tr>
                                        <tr onclick="location.href='/inquiryDetail/2'" style="cursor: pointer">
                                            <th scope="row">3</th>
                                            <td>비공개</td>
                                            <td>김철*</td>
                                            <td>2023/03/01</td>
                                        </tr>
                                        <tr>
                                            <td>-</td>
                                            <td><i class="fa-solid fa-arrow-turn-down-right"></i> Re : 비공개</td>
                                            <td>관리자</td>
                                            <td>2023/03/01</td>
                                        </tr>
                                        <tr onclick="location.href='/inquiryDetail/1'" style="cursor: pointer">
                                            <th scope="row">1</th>
                                            <td>비공개</td>
                                            <td>박은*</td>
                                            <td>2023/02/28</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="my-2"></div>
                            <a href="/regist/inquiry" class="btn btn-secondary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-right"></i>
                                        </span>
                                <span class="text">글쓰기</span>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
<%@include file="../../includes/footer.jsp"%>

<script type="text/javascript">
    var inquiryData = ${INQUIRY_LIST};
    console.log(inquiryData);
</script>