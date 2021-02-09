<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*"%>
<html>
  <head>
    <%@ include file="jsp/HeaderHome.jsp"%>
    <style>
      .form-group.required .control-label:after {
        content:" *";
        color: #006db6;
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
  </head>
  <body>
      <h1>JDBC Connection</h1>

<%
  try {
    java.sql.Connection con;
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/ieee_ensias?allowPublicKeyRetrieval=true&useSSL=false", "root", "choub");
    out.println ("database successfully opened.");
  }
  catch(SQLException e) {
    out.println("SQLException caught: " +e.getMessage());
  }
%>
  <%@ include file="jsp/NavbarIndex.jsp"%>
  <div class="view"
         style="background-image: url('./img/home-bg.png'); background-repeat: no-repeat; background-size: cover;">
      <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
        <div class="text-center white-text mx-5 wow fadeIn">
          <h1 class="mb-4 text-center">
            <img src="./img/logo-shape.png" style="display: block; margin-left: auto; margin-right: auto; width: 10%">
          </h1>
          <p>
            <strong>It's never too late to join IEEE</strong>
          </p>

          <p class="mb-4 d-none d-md-block">
            <strong>The world's largest professional association dedicated to advancing technological innovation and excellence for the benefit of humanity</strong>
          </p>

          <a  href="jsp/login.jsp" class="btn btn-outline-white btn-lg">
            Sign in
          </a>
          <a  href="jsp/signup.jsp" class="btn btn-outline-white btn-lg ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'invisible': ''}">
            Sign up
          </a>
        </div>
      </div>
    </div>

    <main>
      <div class="container">
        <section class="mt-5 wow fadeIn">
          <h3 class="h3 text-center mb-4">FAQ</h3>
          <div class="line-shape mb-5"></div>
          <div class="row">
            <div class="col-md-6 mb-4">
              <img src="img/IEEE.png" style="width: 50%"
                   alt="faq">
            </div>
            <div class="col-md-6 mb-4">
              <h3 class="h3 mb-3">Who are we ?</h3>
            
              <p>
             The IEEE ENSIAS Student Branch was founded in 2013 by our counselor "Prof. Mohamed Essaaidi", Past Dean of ENSIAS, Founder & Past Chair of the IEEE Morocco Section.
              </p>
              <a  href="/faq"
                 class="btn btn-red outline-white btn-lg" style="border: 2px solid white;">FAQ
                <i class="fa fa-question-circle ml-1"></i>
              </a>
            </div>
          </div>
        </section>

        <hr class="my-5">

        <section>
          <h3 class="h3 text-center mb-4">Get in touch with us</h3>
          <div class="line-shape mb-4"></div>
          <div class="row wow fadeIn">
            <div class="col-lg-5 col-md-12 px-4 mt-3">
              <div class="row">
                <div class="col-1">
                  <i class="fas fa-map-marker-alt"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Address</h5>
                  <p class="grey-text">Avenue Mohamed Ben Abdellah Regragui, Rabat</p>
                </div>
              </div>
              <div style="height:30px"></div>
              <div class="row">
                <div class="col-1">
                  <i class="fas fa-phone"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Phone</h5>
                  <p class="grey-text">+212607870012</p>
                </div>
              </div>
              <div style="height:30px"></div>
              <div class="row">
                <div class="col-1">
                  <i class="fas fa-at"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Email</h5>
                  <p class="grey-text">ieeesbensias@gmail.com</p>
                </div>
              </div>
            </div>
            <div class="col-lg-7 col-md-12">
              <form class="text-center" style="color: #757575;">
                <div class="md-form mt-3">
                  <input type="text" id="materialContactFormName" class="form-control">
                  <label for="materialContactFormName">Name</label>
                </div>
                <div class="md-form">
                  <input type="email" id="materialContactFormEmail" class="form-control">
                  <label for="materialContactFormEmail">E-mail</label>
                </div>
                <div class="md-form">
              <textarea type="text" id="materialContactFormMessage" class="form-control md-textarea"
                        rows="3"></textarea>
                  <label for="materialContactFormMessage">Message</label>
                </div>
                <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                        type="submit" style="border-color: #006db6 !important; color: #006db6 !important;">
                  Send
                </button>
              </form>
            </div>
          </div>
        </section>
      </div>
    </main>

    <%@ include file="jsp/Footer.jsp"%>
    <%@include file="jsp/Toastr.jsp"%>
  </body>
</html>
