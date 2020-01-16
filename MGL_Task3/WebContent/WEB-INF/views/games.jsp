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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
		<div class="panel panel-default">
			<div class="panel-heading text-light">
				<span class="lead">Game Submission</span>
			</div>
			<div class="formcontainer">
				<div class="tablecontainer">
					<form ng-submit="MGL_T3_ctrl.addGame()" name="gameForm" class="form-horizontal">
						<table class="table table-dark text-light">
							<tr>
								<td>
									<input type="hidden" ng-model="MGL_T3_ctrl.game.game_id" /> <label class="col-md-2 control-lable text-light" for="game_name">Name*</label>
									<div class="col-md-9">
										<input type="text" ng-model="MGL_T3_ctrl.game.game_name" id="game_name" class="game_name form-control input-sm" placeholder="Enter the name of the new game [required]" required ng-minlength="1" />
										<div class="has-error" ng-show="gameForm.$dirty">
											<span ng-show="gameForm.game_name.$error.required">This is a required field</span>
											<span ng-show="gameForm.game_name.$error.minlength">Minimum length required is 3</span>
											<span ng-show="gameForm.game_name.$invalid">This field is invalid </span>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<label class="col-md-2 control-lable text-light" for="game_genre">Game Genre</label>
									<div class="col-md-9">
										<input type="text" ng-model="MGL_T3_ctrl.game.game_genre" id="game_genre" class="form-control input-sm" placeholder="Enter the genre of the new game" />
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<label class="col-md-2 control-lable text-light" for="game_releaseDate">Game Release Date* (yyyy-MM-dd)*</label>
									<div class="col-md-9">
										<input type="text" ng-model="MGL_T3_ctrl.game.game_releaseDate" id="game_releaseDate" class="form-control input-sm" placeholder="Enter relase date of the new game  (yyyy-MM-dd)" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="form-actions p-2">
									<input type="submit" value="{{!MGL_T3_ctrl.game.game_id ? 'Add' : 'Update'}}" class="btn btn-outline-light" ng-disabled="myForm.$invalid">
									<input type="button" value="Reset" class="btn btn-light" ng-click="MGL_T3_ctrl.resetGame()"> 
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="panel panel-default"></div>
		</div>
		<div class="panel panel-default">
			<div class="tablecontainer text-center">
				<table class="table table-dark table-striped text-light">
					<thead>
						<tr>
							<td>List of all games</td>
						</tr>
						<tr>
							<th ng-hide="true">Game ID</th>
							<th>Game Name</th>
							<th>Game Genre</th>
							<th>Release Date</th>
							<th>Reviews</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="currentGame in MGL_T3_ctrl.games">
							<td ng-hide="true">
								<span ng-bind="currentGame.game_id"></span>
							</td>
							<td>
								<span ng-bind="currentGame.game_name"></span>
							</td>
							<td>
								<span ng-bind="currentGame.game_genre"></span>
							</td>
							<td>
								<span>{{currentGame.game_releaseDate | date: 'longDate'}}</span>
							</td>
							<td>
								<button type="button" ng-click="MGL_T3_ctrl.fetchAllReviews(currentGame.game_id)" class="btn btn-outline-light custom-width">Reviews</button>
							</td>
							<td>
								<button type="button" ng-click="MGL_T3_ctrl.editGame(currentGame)" class="btn btn-outline-light custom-width">Edit</button>
								<button type="button" ng-click="MGL_T3_ctrl.deleteGame(currentGame.game_id)" class="btn btn-light custom-width">Remove</button>
							</td>
						</tr>
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
