package com.MGL_Task3.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MGL_Task3.controller.MGL_Endpoint_Constants;
import com.MGL_Task3.model.Game;

@Service
public class Game_Service_Impl implements Game_Service {

    private static RestTemplate restTemplate = new RestTemplate();
    private static final String MAIN_URI = "http://localhost:8080/MGL_Task3";

    @Override
    @Transactional
    public void saveGame(Game game) {
	Game_Service_Impl.restTemplate.postForLocation(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.CREATE_GAME,
		game);
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
	Game_Service_Impl.restTemplate.put(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.UPDATE_GAME, game);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
	Game_Service_Impl.restTemplate.put(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.DELETE_GAME, id);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
	ResponseEntity<Game[]> gameResponseEntity = Game_Service_Impl.restTemplate
		.getForEntity(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.FETCH_ALL_GAMES, Game[].class);

	Game[] games = gameResponseEntity.getBody();

	List<Game> gameList = Arrays.asList(games);

	return gameList;
    }

}