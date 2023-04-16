<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../../includes/header.jsp"%>

<div class="row" style="margin-bottom:20px; margin-left:1px;">
    <div class="col-lg-12">
        <h1 class="page-header">inquiry 상세</h1>
    </div>
</div>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
<%--    <h1 class="h3 mb-4 text-gray-800">News 상세</h1>--%>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">No : ${id}</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive" style="text-align:center;">
                <table id="datatable-scroller"
                       class="table table-bordered tbl_Form">
                    <caption></caption>
                    <colgroup>
                        <col width="300px" />
                        <col />
                    </colgroup>
                    <tbody>
                    <tr>
                        <th class="active" >공개여부</th>
                        <td class="form-inline">비공개 <span class="text-gray-500 text-xs" style="margin-left: 50px;">* 비공개 글로 게시가 됩니다.</span></td>
                    </tr>
                    <tr>
                        <th class="active" >작성자</th>
                        <td class="form-inline">${writer} </td>
                    </tr>
                    <tr>
                        <th class="active" >제목</th>
                        <td class="form-inline">${title} </td>
                    </tr>
                    <tr>
                        <th class="active">내용</th>
                        <td class="form-inline"><textarea
                                id="inquiryContent" name="inquiryContent" cols="100" rows="10"
                                class="form-control" readonly>${content}</textarea> </td>
                    </tr>
                    </tbody>
                    <tr>
                        <th class="active">댓글내용</th>
                        <td class="form-inline"><textarea
                                id="reply" name="reply" cols="100" rows="1"
                                class="form-control" placeholder="댓글을 입력해주세요."></textarea> </td>
                    </tr>

                </table>
                <div style="margin-right:50px; float: right;">
                    <button type="submit" onclick="location.href='/news/reply/${id}'" class="btn btn-primary">답글달기</button>
                    <a href="/inquiry/delete" onclick="doDelete()" class="btn btn-danger">삭제</a>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<script>
    function doDelete(){
        confirm("삭제하시겠습니까?");
    }
</script>

<%@include file="../../includes/footer.jsp"%>


