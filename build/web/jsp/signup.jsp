<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="Header.jsp" %>
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
</head>
<body>

<%@include file="Navbar.jsp"%>
<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">
    

    <div class="row">
        <div class="col col-md-12">

            <div class="wrapper wrapper--w790">
                <div class="card">
                    <h5 class="card-header white-text text-center py-4" style="background-color: #006db6;">
                        <strong>Sign Up</strong>
                    </h5>
                    <div class="card-body">
                        <form method="post" action="addmember.jsp">
                            <div class="row row-space">
                                <div class="form-group required col-sm-6">
                                    <label for="prenom" class='control-label'>First Name</label>
                                    <input type="text" name="firstname" class="form-control" id="firstname" placeholder="John">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label for="nom" class='control-label'>Last Name</label>
                                    <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Smith">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="filliere" class='control-label'>Branch</label>
                                    <input type="text" name="branch" class="form-control" id="branch" placeholder="ex : IWIM">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="tele" class='control-label'>Phone Number</label>
                                    <input type="text" name="phone" class="form-control" id="phone" placeholder="+212 6 07 00 00 00">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="email" class='control-label'>Email</label>
                                    <input type="email" name="email" class="form-control" id="email" placeholder="example@mail.com">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="password" class='control-label'>Password</label>
                                    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="form-group required col-sm-6">
                                    <label  class='control-label'>Cell</label>
                                    <select class="browser-default custom-select form-control" name="cell">
                                        <option value="" disabled selected>Select your desired cell</option>
                                        <option value="Sponsoring">Sponsoring</option>
                                        <option value="Event">Event</option>
                                        <option value="Media">Media</option>
                                        <option value="Tutorial">Tutorial</option>
                                        <option value="Design">Design</option>                                        
                                    </select>
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label class='control-label'>Promotion</label>
                                    <select class="browser-default custom-select form-control" name="promo">
                                        <option value="" disabled selected>Select your End of Studies year</option>
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                        <option value="2024">2024</option>
                                        <option value="2025">2025</option>  
                                    </select>
                                </div>
                            </div>
                            <!-- Submit -->
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                            type="submit" style="border-color: #006db6 !important; color: #006db6 !important;">
                                       Sign up
                                    </button>
                                </div>

                            </div>


                        </form>

                    </div>
                </div>
            </div>


        </div>

    </div>

</div>

<!--- FOOTER -->
<%@ include file="Footer.jsp" %>
</body>
</html>
