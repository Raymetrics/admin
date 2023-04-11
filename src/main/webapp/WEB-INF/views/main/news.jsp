<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../includes/header.jsp"%>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">News</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>작성일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>System Architect</td>
                                            <td>2011/04/25</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Accountant</td>
                                            <td>2011/07/25</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Junior Technical Author</td>
                                            <td>2009/01/12</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>Senior Javascript Developer</td>
                                            <td>2012/03/29</td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>Accountant</td>
                                            <td>2008/11/28</td>
                                        </tr>
                                        <tr>
                                            <td>6</td>
                                            <td>Integration Specialist</td>
                                            <td>2012/12/02</td>
                                        </tr>
                                        <tr>
                                            <td>7</td>
                                            <td>Sales Assistant</td>
                                            <td>2012/08/06</td>
                                        </tr>
                                        
                                    </tbody>
                                </table>
                            </div>

                            <div class="my-2"></div>
                            <a href="/regist/news" class="btn btn-secondary btn-icon-split">
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

<%@include file="../includes/footer.jsp"%>