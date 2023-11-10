<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../includes/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row mt-4">
        <div class="col-lg-12">
            <h1 class="page-header">Inquiry 상세</h1>
        </div>
    </div>

    <div class="card shadow mb-4">

        <div class="card-header py-3 d-flex justify-content-between align-items-center">
            <h6 class="m-0 font-weight-bold text-primary">No : ${inquiryNo}</h6>
            <a href="javascript:void(0);" onclick="deleteInquiry(${inquiryNo})" class="btn btn-danger">게시글 삭제</a>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered tbl_Form">
                    <tbody>
                    <tr>
                        <th class="active">공개여부</th>
                        <td>비공개 <span class="text-gray-500 text-xs ml-4">* 비공개 글로 게시가 됩니다.</span></td>
                    </tr>
                    <tr>
                        <th class="active">작성자</th>
                        <td>${writer}</td>
                    </tr>
                    <tr>
                        <th class="active">제목</th>
                        <td>${title}</td>
                    </tr>
                    <tr>
                        <th class="active">내용</th>
                        <td>${content}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- 댓글 목록 출력 테이블 -->
            <c:if test="${not empty replyList}">
                <div class="table-responsive mt-4">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th style="width: 5%;">no</th>
                            <th style="width: 50%;">내용</th>
                            <th>작성자</th>
                            <th>작성 일시</th>
                            <th>삭제</th>
                        </tr>
                        </thead>
                        <tbody>
                            <!-- replyList에 댓글 데이터가 담겨있다고 가정 -->
                            <c:forEach var="inquiryReply" items="${replyList}" varStatus="vs">
                                <tr>
                                    <td>${vs.index+1}</td>
                                    <td>${inquiryReply.contents}</td>
                                    <td>${inquiryReply.writer}</td>
                                    <td>${inquiryReply.regDt}</td>
                                    <td>
                                        <button type="button" onclick="deleteReply(${inquiryReply.replyNo}, ${inquiryNo});" class="btn btn-danger btn-sm">삭제</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <div class="mt-4">
                <div class="input-group">
                    <input type="text" id="reply" name="reply" cols="100" rows="1" class="form-control" placeholder="댓글을 입력해주세요."></input>
                    <div class="input-group-append">
                        <button type="button" onclick="submitReply();" class="btn btn-primary">댓글 등록</button>
                    </div>
                </div>
            </div>


        </div>
    </div>

    <form id="form" name="form" action="/inquiry/reply" method="post">
        <input type="hidden" id="regAdminNo" name="regAdminNo" value="${regAdminNo}">
        <input type="hidden" id="inquiryNo" name="inquiryNo" value="${inquiryNo}">
        <input type="hidden" id="contents" name="contents">
    </form>
</div>

<script>

    function submitReply() {
        try {
            if($("#reply").val()=="" || !$("#reply").val()){
                alert("댓글 내용을 입력해주세요.")
                return;
            }

            $("#contents").val($("#reply").val());
            document.form.submit();

        } catch (e) {}
    }

    function deleteInquiry(inquiryNo) {
        if (confirm("게시글을 삭제하시겠습니까?")) {
            $.ajax({
                type: "DELETE",
                url: "/inquiry/delete/" + inquiryNo, // 삭제를 처리하는 서버 엔드포인트 URL
                success: function(response) {
                    if (response.success) {
                        // 삭제 성공 시 처리
                        alert("게시글이 삭제되었습니다.");
                        // /inquiry/list 페이지로 이동
                        window.location.href = "/inquiry/list";
                    } else {
                        // 삭제 실패 시 처리
                        alert("게시글 삭제에 실패했습니다.");
                    }
                },
                error: function() {
                    // 서버 요청 실패 시 처리
                    alert("서버 요청에 실패했습니다.");
                }
            });
        }else{
            return false;
        }
    }

    function deleteReply(replyNo, inquiryNo) {
        if (confirm("댓글을 삭제하시겠습니까?")) {
            $.ajax({
                type: "DELETE",
                url: "/inquiry/delete/reply", // 댓글 삭제를 처리하는 서버 엔드포인트 URL
                data: { replyNo: replyNo, inquiryNo: inquiryNo },
                success: function(response) {
                    if (response.success) {
                        // 삭제 성공 시 처리
                        alert("댓글이 삭제되었습니다.");
                        location.reload();
                        // 페이지 리로드 또는 댓글을 화면에서 제거하는 등의 처리를 수행할 수 있습니다.
                    } else {
                        // 삭제 실패 시 처리
                        alert("댓글 삭제에 실패했습니다.");
                    }
                },
                error: function() {
                    // 서버 요청 실패 시 처리
                    alert("서버 요청에 실패했습니다.");
                }
            });
        }else{
            return false;
        }
    }
</script>

<%@ include file="../../includes/footer.jsp" %>