<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>
<body>

<section class="col-lg-6 col-md-5">
	<table class="table table-hover">
		<tr>
			<td><p>${ userProfile.firstName} ${ userProfile.lastName} </p></td>
			<td><p>${ userProfile.firstName} ${ userProfile.lastName} </p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.lineOne}</p></td>
			<td><p>${ userProfile.billingAddress.lineOne}</p></td>
		<tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.lineTwo}</p></td>
			<td><p>${ userProfile.billingAddress.lineTwo}</p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.state}</p></td>
			<td><p>${ userProfile.billingAddress.state}</p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.shippingAddress.zipCode}</p></td>
			<td><p>${ userProfile.billingAddress.zipCode}</p></td>
		</tr>
		<tr>
			<td><p>${ userProfile.phone}</p></td>
			<td><p>${ userProfile.phone}</p></td>
		</tr>
		<tr>
			<td>Ship to this address</td>
			<td>Ship to this address</td>
		</tr>
	</table>		
</section>

<section class="newAddress">
	<form action="checkout" method="get">
	New Address<br />
    <div class="line"><label for="lineOne">Line one *: </label><input type="text" id="lineOne" name="lineOne" value = "141 4th st." /></div>
    <div class="line"><label for="lineTwo">Line Two *: </label><input type="text" id="lineTwo" name="lineTwo" value = "N/A" /></div>
    <div class="line"><label for="state">State *: </label><input type="text" id="state" name="state" value = "North Carolina." /></div>
    <div class="line"><label for="zipCode">Zip code *: </label><input type="text" id="zipcode" name="zipCode" value = "53242" /></div>
    <input type="hidden" name="amount" value="${subtotatl}" />
    <input type="submit" value="Proceed For Payment" />
    </form>
</section>


</body>

<%@include file="includes/footer.jsp" %>