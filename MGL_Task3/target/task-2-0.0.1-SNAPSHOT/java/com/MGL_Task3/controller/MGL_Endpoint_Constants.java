package com.MGL_Task3.controller;

public class MGL_Endpoint_Constants {

    /**
     * Backend Main URI
     */
    public static final String BACKEND_MAIN_URI = "http://localhost:8080/MGL_Task3";
    /**
     * URI endpoints for MGL_Task3_Controller
     */
    public static final String BLANK_ENDPOINT = "/";
    public static final String HOME = "/home";
    public static final String REVIEWS_FOR_GAME = "/reviewsForGame";
    public static final String ADD_REVIEW = "/addReview";
    public static final String GAMES = "/games";
    public static final String FETCH_ALL_GAMES = "/fetchAllGames";
    public static final String FETCH_REVIEWS_FOR_GAME = "/fetchReviewsForGame";
    public static final String CREATE_GAME = "/createGame";
    public static final String UPDATE_GAME = "/updateGame";
    public static final String DELETE_GAME = "/deleteGame";

    /**
     * URI endpoints for Review_Controller
     */
    public static final String SHOW_FORM_FOR_ADD_REVIEW = "/review/showForm";
    public static final String SAVE_REVIEW = "/review/saveReview";
    public static final String UPDATE_FORM = "/review/updateForm";
    public static final String DELETE_REVIEW = "/review/deleteReview";
    public static final String UPDATE_REVIEW = "/review/updateReview";

}
