<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<style>
body { padding-top:30px; }
.form-control { margin-bottom: 10px; }
</style>

<script type="text/javascript">
    function clear(){
    	document.getElementById("addOrderAddress").reset();
    }

</script>

<section class="container">

    <form:form name="addOrderAddress" modelAttribute="OrderAddress"  action="/order/address" method="post">
        <div>
            <table>
                <tr>
                    <td>Order Delivery Address:
                        <select id="address" name="deliveryId">
                            <option selected="selected">--Select--</option>
<%--                             <c:forEach items="${Address}" var="address">
                                <option value="${address.getAddressId()}">${address.getAddressId()}</option>
                            </c:forEach>
                        </select> --%>
                    </td>
                    <td><button type="button" class="btn btn-primary" onclick="clear()">New Address</button></td>
                </tr>
            </table>

        </div>
        <div id="addAddress" style="display: none;">
<%--             <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}" /> --%>
            <section class="container">
                <h4>New Delivery Address</h4>
                <div class="container">
				    <div class="row">
				        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
				            <legend> Order Address!</legend>
				            <form:form action="#" modelAttribute="OrderAddress" method="post" class="form" role="form">
				            <div class="row">
				                <div class="col-xs-6 col-md-6">
				                    <form:input class="form-control" path="street" name="street" placeholder="Street" type="text" id="street"
				                        required="autofocus"/>
				                </div>
				                <div class="col-xs-6 col-md-6">
				                    <form:input class="form-control" path="city" name="city" placeholder="City" type="text" id="city"  />
				                </div>
				            </div>
				            <form:input class="form-control" path="state" name="state" placeholder="State" id="state" type="text" />
				            <form:input class="form-control" path="zip" name="zip" placeholder="ZipCode" id="zip" type="text" />
				            <form:input class="form-control" path="phoneNo" name="phoneNo" placeholder="Phone" id="phoneNo" type="text" />
				            
				            <br />
				            <br />
				            <button class="btn btn-lg btn-primary btn-block" type="submit">
				                PlaceOrder</button>
				            </form:form>
				        </div>
				    </div>
				</div>
            </section>

        </div>
    </form:form>

</section>




