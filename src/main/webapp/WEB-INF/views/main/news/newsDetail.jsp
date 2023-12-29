<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../../includes/header.jsp"%>

<div class="row" style="margin-bottom:20px; margin-left:1px;">
    <div class="col-lg-12">
        <h1 class="page-header">News 상세</h1>
    </div>
</div>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
<%--    <h1 class="h3 mb-4 text-gray-800">News 상세</h1>--%>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">No : ${NEWS.newsNo}</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table id="datatable-scroller"
                       class="table table-bordered tbl_Form">
                    <caption></caption>
                    <colgroup>
                        <col width="300px" />
                        <col />
                    </colgroup>
                    <tbody>
                    <tr>
                        <th class="active"  style="text-align:center;">작성자</th>
                        <td class="form-inline">${NEWS.regAdminName} </td>
                    </tr>
                    <tr>
                        <th class="active" style="text-align:center;">작성일</th>
                        <td class="form-inline">${NEWS.regDt} </td>
                    </tr>
                    <tr>
                        <th class="active"  style="text-align:center;">제목</th>
                        <td class="form-inline">${NEWS.title} </td>
                    </tr>
                    <tr>
                        <th class="active" colspan="2">
                            <div>
                                ${NEWS.contents}
                            </div>
                        </th>
                    </tr>
                    </tbody>
                </table>
                <div style="margin-right:50px; float: right;">
                    <button type="submit" onclick="location.href='/news/edit/${NEWS.newsNo}'" class="btn btn-primary">수정</button>
                    <a href="/news/list" class="btn btn-danger">취소</a>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="../../includes/footer.jsp"%>


