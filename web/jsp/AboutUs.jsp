<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<style>
    .form-group.required .control-label:after {
        content:" *";
        color:red;
    }
    .form-control:focus {
        border-color: #006db6;
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
    }
    select option:hover {
        background: #006db6;
        color: white;
    }
</style>
<html>
    <head>
        <%@include file="Header.jsp"%>
    </head>
    <body>

        <!--- Navbar -->
        <%@ include file="/jsp/Navbar.jsp" %>
        <div class="container col-md-8  pt-5 ">
            <br><br>



            <div class="best-features about-features">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="section-heading">
                                <h2>Our Background</h2>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="left-content">
                                <h4>History of IEEE</h4>
                                <p>IEEE's roots go back to 1884 when electricity began to become a major influence in society. There was one
                                    major established electrical industry, the telegraph, which since the 1840s had come to connect the world
                                    with a data communications system faster than the speed of transportation. The telephone and electric
                                    power and light industries had just gotten underway.</p>
                                <h4>IEEE ENSIAS Student Branch </h4>
                                <p>IEEE ENSIAS Student Branch is a basic operating organizational unit of IEEE constituted by students and
                                    graduated students of ENSIAS. The ENSIAS’s Student Branch members are gathered in order to begin
                                    networking in their areas of interest, work on real projects, benefit from career development tools and
                                    develop critical skills outside of the classroom, along with organising events and participate in
                                    competitions.</p>
                                <p>The IEEE ENSIAS Student Branch was founded in <em><strong>2013</strong></em> by our counselor <em><strong>"Prof. Mohamed Essaaidi"</strong></em>, Past Dean
                                    of ENSIAS, Founder & Past Chair of the IEEE Morocco Section.</p>

                                <ul class="social-icons">
                                    <li><a href="https://www.facebook.com/ieee.ensias.studentb/" TARGET="_blank"><i
                                                class="fa fa-facebook"></i></a></li>

                                    <li><a href="https://www.youtube.com/channel/UCcvFuFQie5m55sO9KK-mWrA" TARGET="_blank"><i
                                                class="fa fa-youtube"></i></a></li>
                                    <li><a href="https://www.instagram.com/ieeesbensias/" TARGET="_blank"><i class="fa fa-instagram"></i></a>
                                    </li>
                                    <li><a href="https://www.linkedin.com/company/ieee-ensias-student-branch/" TARGET="_blank"><i
                                                class="fa fa-linkedin"></i></a></li>
                                    <li><a href="https://twitter.com/EnsiasSb" TARGET="_blank"><i
                                                class="fa fa-twitter"></i></a></li>
                                    <li><a href="https://medium.com/ieee-ensias-student-branch" TARGET="_blank"><i
                                                class="fa fa-medium"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="right-image">
                                <img style="margin-bottom: 20px;" src="${pageContext.request.contextPath}/img/IEEE.png" alt="" width="300px"></br>
                                <img src="${pageContext.request.contextPath}/img/2017.jpg" alt="" width="300px">
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <%@include file="Footer.jsp"%>
    </body>
</html>

