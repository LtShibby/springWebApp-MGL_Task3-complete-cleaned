<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="../resources/js/app.js"></script>
<script src="../resources/js/service/MGL_Task3.service.js"></script>
<script src="../resources/js/controller/MGL_Task3.controller.js"></script>
<!-- Favicons -->
<link rel="apple-touch-icon" sizes="180x180" href="<c:url value='../resources/images/apple-touch-icon.png' />">
<link rel="icon" type="image/png" sizes="32x32" href="<c:url value='../resources/images/favicon-32x32.png' />">
<link rel="icon" type="image/png" sizes="16x16" href="<c:url value='../resources/images/favicon-16x16.png' />">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Mist Library Task 1- Synch</title>
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
		<a class="navbar-brand" href="../home">
			<img src="../resources/images/MGLlogo.png" width="90" height="60" alt="">
		</a>
		<a class="nav-item nav-link" href="../games">Games</a>
		<br>
	</nav>
	<br />
	<div class="container" ng-controller="MGL_Task3_Controller as MGL_T3_ctrl">
		<div class="panel-heading text-light">
			<h2>Review Submitted</h2>
			<div class="panel panel-info">
				<div class="panel-body">
					<br />
					<table class="table table-dark text-light">
						<tr>
							<td>ReviewBody</td>
							<td>
								<p>${submittedReview.review_body}</p>
							</td>
						</tr>
						<tr>
							<td>Author</td>
							<td>
								<p>${submittedReview.review_author}</p>
							</td>
						</tr>
						<tr>
							<td>Rating</td>
							<td>
								<p>${submittedReview.review_rating}</p>
							</td>
						</tr>
						<tr>
							<td>
								<a class="nav-item nav-link" href="../reviewsForGame?review_game_id=${submittedReview.review_game_id}">Return to reviews</a>
							</td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"></script>

</html>
