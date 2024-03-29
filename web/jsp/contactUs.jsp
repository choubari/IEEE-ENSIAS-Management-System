<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp" %>
</head>
<body>
<%@include file="Navbar.jsp" %>

<br><br><br>

<div class="container col-md-8 align-content-center">
    <!--Section: Contact v.2-->
    <section class="mb-4">

        <!--Section heading-->
        <div class="section-title text-center wow zoomIn mt-4">
            <h1>Get in touch with us</h1>
            <span></span>
        </div>
        <!--Section description-->
        <p class="text-center w-responsive mx-auto ">Do you have any questions? Please do not hesitate to contact us
            directly. Our team will come back to you within
            a matter of hours to help you.</p>

        <c:if test="${not empty MessageSuccess}">
            <h5 class='h5 text-center  mt-4'>
                <div class='alert alert-success'>Message sent</div>
            </h5>
        </c:if>

        <div class="row">

            <!--Grid column-->
            <div class="col-md-9 mb-md-0 mb-5">
                <form id="contact-form" name="contact-form" action="${pageContext.request.contextPath}/ContactForm" method="POST">

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="text" id="name" name="name" class="form-control"  placeholder="Your name">
                            </div>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="text" id="email" name="email" class="form-control"  placeholder="Email">
                            </div>
                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form mb-0">
                                <input type="text" id="subject" name="subject" class="form-control"  placeholder="Subject">
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-12">

                            <div class="md-form">
                                <textarea type="text" id="message" name="message" rows="2"
                                          class="form-control md-textarea"  placeholder="Your message"></textarea>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->

                    <div class="text-center text-md-left">
                        <button class="btn btn-red btn-block col-md-2 my-4" name="submit" type="submit">Send</button>
                    </div>

                </form>
                <c:if test="${not empty MessageFaild}">
                    <div class='alert ${status == 'success' ? 'alert-success' : 'alert-danger'}'>${MessageFaild}</div>
                </c:if>
                <div class="status"></div>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-3 text-center">
                <ul class="list-unstyled mb-0">
                    <li><i class="fas fa-map-marker-alt fa-2x"></i>
                        <p>Madinat Al Irfane, Rabat 10 000, MOROCCO</p>
                    </li>

                    <li><i class="fas fa-phone mt-4 fa-2x"></i>
                        <p>+ 212 607 8700 12</p>
                    </li>

                    <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                        <p>ieeesbensias@gmail.com</p>
                    </li>
                </ul>
            </div>
            <!--Grid column-->

        </div>

    </section>
</div>
<!--Section: Contact v.2-->


<%@include file="Footer.jsp" %>
</body>
</html>
