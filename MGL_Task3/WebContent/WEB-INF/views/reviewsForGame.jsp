<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
	<script src="resources/js/app.js"></script>
	<script src="resources/js/service/MGL_Task3.service.js"></script>
	<script src="resources/js/controller/MGL_Task3.controller.js"></script>
	<!-- Favicons -->
	<link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/resources/images/apple-touch-icon.png' />">
	<link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/resources/images/favicon-32x32.png' />">
	<link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/resources/images/favicon-16x16.png' />">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Mist Library Task 1- Games</title>
	<style type="text/css">
		body {
			background-image:
				url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
			background-repeat: no-repeat;
			background-size: cover;
		}

	</style>
</head>

<body ng-app="MGL_Task3_app" class="ng-cloak">
	<nav id="MistLibrary-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="home">
			<img src="resources/images/MGLlogo.png" width="90" height="60" alt="">
		</a>
		<a class="nav-item nav-link" href="games">Games</a>
		<br>
	</nav>
	<br>
	<div class="container" ng-controller="MGL_Task3_Controller as MGL_T3_ctrl">
		<div class="panel panel-default" ng-hide="myVar">
			<div class="panel-heading text-light">
				<span class="lead">Review Submission</span>
			</div>
			<div class="formcontainer">
				<div class="tablecontainer">
					<form:form name="submitReviewForm" method="put" action='{{MGL_T3_ctrl.this_review_game_id}}'>
						<table class="table table-dark text-light">
							<tr>
								<td>
									<label>Review Body*</label>
								</td>
								<td>
									<textarea name="review_body" ng-model="MGL_T3_ctrl.review.review_body" class="form-control" placeholder="What did you like/dislike about the game? [required]"
										required></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label>Author</label>
								</td>
								<td>
									<input type="text" name="review_author" ng-model="MGL_T3_ctrl.review.review_author" class="form-control"
										placeholder="Your name (leave black to leave an anonymous review)"></input>
								</td>
							</tr>
							<tr>
								<td>
									<label>Rating</label>
								</td>
								<td>
									<select id="ratingSelection" name="review_rating" ng-model="MGL_T3_ctrl.review.review_rating" class="chzn-select" style="width: 100px" required>
										<option value=1>1</option>
										<option value=2>2</option>
										<option value=3>3</option>
										<option value=4>4</option>
										<option value=5>5</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="form-actions p-2">
									<input type="submit" class="btn btn-outline-light">
									<input type="button" value="Reset" class="btn btn-light" ng-click="MGL_T3_ctrl.resetReview()">
								</td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
			<div class="panel panel-default"></div>
		</div>
		<div class="panel panel-default">
			<div class="tablecontainer">
				<table class="table table-dark table-striped text-light">
					<thead>
						<c:set var="numberOfReviews" scope="session" value="${reviewsForGame.size()}" />
						<c:if test="${numberOfReviews < 1}">
							<tr>
								<td>There are currently no reviews for this game.</td>
							</tr>
						</c:if>
						<c:if test="${numberOfReviews > 0}">
							<tr>
								<td>List of all reviews</td>
							</tr>
							<tr>
								<th data-ng-hide="true">Game ID</th>
								<th>Review</th>
								<th>Author</th>
								<th>Rating</th>
								<th></th>
							</tr>
						</c:if>
					</thead>
					<tbody>
						<c:forEach var="tempReview" items="${reviewsForGame}">
							<!-- construct an "update" link with game id -->
							<c:url var="updateLink" value="/review/updateForm">
								<c:param name="review_id" value="${tempReview.review_id}" />
							</c:url>
							<!-- construct an "delete" link with game id -->
							<c:url var="deleteLink" value="/review/deleteReview">
								<c:param name="review_id" value="${tempReview.review_id}" />
							</c:url>
							<tr>
								<td>${tempReview.review_body}</td>
								<td>${tempReview.review_author}</td>
								<td>${tempReview.review_rating}</td>
								<td>
									<!-- display the update link -->
									<a href="${updateLink}">Update</a> | <a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete this review?'))) return false">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<br>
				<br>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"></script>

</html>
