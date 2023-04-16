<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../../includes/header.jsp"%>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">관리자 정보 관리</h1>

                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">관리자 정보</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive" style="text-align:center;">
                            <table id="datatable-scroller"
                                   class="table table-bordered tbl_Form">
                                <caption></caption>
                                <colgroup>
                                    <col width="400px" />
                                    <col />
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th class="active" >아이디</th>
                                    <td class="form-inline"><input type="text" id="memberId"
                                                                   name="board_writer" class="form-control" style="width: 200px" value="admin" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active">이름</th>
                                    <td class="form-inline"><input type="text" id="name"
                                                                   name="board_title" class="form-control" style="width: 200px" value="관리자"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active" >연락처</th>
                                    <td class="form-inline"><input type="text" id="phone"
                                                                   name="board_writer" class="form-control" style="width: 200px" value="010-8689-3084" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active">비밀번호</th>
                                    <td class="form-inline"><input type="password" id="password"
                                                                   name="board_title" class="form-control" style="width: 200px" value="admin"/>

<%--                                        <a href="#" onclick="openNewPw(document.getElementsByClassName('changePw'))" class="btn btn btn-secondary btn-icon-split" style="margin-left: 50px;">--%>
<%--                                        <span class="icon text-white-50">--%>
<%--                                            <i class="fas fa-arrow-right"></i>--%>
<%--                                        </span>--%>
<%--                                            <span class="text">비밀번호 변경</span>--%>
<%--                                        </a>--%>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active changePw" >새 비밀번호</th>
                                    <td class="form-inline"><input type="text" id="newPassword"
                                                                   name="board_writer" class="form-control" style="width: 200px"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active changePw" >새 비밀번호 확인</th>
                                    <td class="form-inline"><input type="text" id="confirm_newPassword"
                                                                   name="board_writer" class="form-control" style="width: 200px"/>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div style="margin-right:50px; float: right;">
                                <button type="submit" class="btn btn-primary">수정</button>
                                <a href="/board/list" class="btn btn-danger">취소</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<script>
    function openNewPw(obj) {
        alert("Hello World");
        if (obj.style.display=='none') obj.style.display = 'block';
        else if (obj.style.display=='block') obj.style.display = 'none';
    }
</script>
<%@include file="../../includes/footer.jsp"%>


