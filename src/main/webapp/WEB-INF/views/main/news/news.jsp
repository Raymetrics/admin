<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="../../includes/header.jsp"%>
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
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>작성일</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <tr onclick="location.href='/newsDetail/7'" style="cursor: pointer">
                                            <th scope="row">7</th>
                                            <td>쿼리연구소 수출</td></a>
                                            <td>2023/03/06</td>
                                        </tr>
                                        <tr onclick="location.href='/newsDetail/6'" style="cursor: pointer">
                                            <th scope="row">6</th>
                                            <td>서울대학교병원 MOU</td>
                                            <td>2023/03/04</td>
                                        </tr>
                                        <tr onclick="location.href='/newsDetail/5'">
                                            <th scope="row">5</th>
                                            <td>레이메트릭스 국내 섬광체 최초 국산화</td>
                                            <td>2023/03/02</td>
                                        </tr>
                                        <tr onclick="location.href='/newsDetail/4'">
                                            <th scope="row">4</th>
                                            <td>보조선량계 신제품 출시</td>
                                            <td>2023/03/02</td>
                                        </tr>
                                        <tr onclick="location.href='/newsDetail/3'">
                                            <th scope="row">3</th>
                                            <td>캐리마와 MOU</td>
                                            <td>2023/03/01</td>
                                        </tr>
                                        <tr onclick="location.href='/newsDetail/2'">
                                            <th scope="row">2</th>
                                            <td>FTA 체결</td>
                                            <td>2023/02/28</td>
                                        </tr>
                                        <tr onclick="location.href='/newsDetail/1'">
                                            <th scope="row">1</th>
                                            <td>레이메트릭스 첫 수출</td>
                                            <td>2023/02/28</td>
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

<%@include file="../../includes/footer.jsp"%>