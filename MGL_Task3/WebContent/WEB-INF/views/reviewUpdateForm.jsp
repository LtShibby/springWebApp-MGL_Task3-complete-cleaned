<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
	<script src="../resources/js/app.js"></script>
	<script src="../resources/js/service/MGL_Task3.service.js"></script>
	<script src="../resources/js/controller/MGL_Task3.controller.js"></script>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Mist Library Task 1-Landing</title>
	<style type="text/css">
		body {
			background-image:
				url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
			background-repeat: no-repeat;
			background-size: cover;
		}

	</style>
</head>

<body>
	<nav id="MistLibrary-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="../home">
			<img src="../resources/images/MGLlogo.png" width="90" height="60" alt="">
		</a>
		<a class="nav-item nav-link" href="../games">Games</a>
		<br>
	</nav>
	<br>
	<div class="container">
		<div class="panel-heading text-light">
			<h2>Update Review Form</h2>
			<div class="panel panel-info">
				<div class="panel-body">
					<form:form action="updateReview" cssClass="form-horizontal" method="post" modelAttribute="currentReview">
						<!-- need to associate this data with game id -->
						<div>
							<form:hidden path="review_id" />
						</div>
						<div>
							<form:hidden path="review_game_id" />
						</div>
						<table class="table table-dark text-light">
							<tr>
								<td>
									<label>Review Body*</label>
								</td>
								<td>
									<form:input path="review_body" cssClass="form-control" />
								</td>
							</tr>
							<tr>
								<td>
									<label>Review Author</label>
								</td>
								<td>
									<form:input path="review_author" cssClass="form-control" />
								</td>
							</tr>
							<tr>
								<td>
									<label>Review Rating</label>
								</td>
								<td>
									<form:select id="ratingSelection" path="review_rating" itemValue="review_rating" class="chzn-select" style="width: 100px"
										required="required">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>
									<form:button class="btn btn-primary">Submit Review</form:button>
								</td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>