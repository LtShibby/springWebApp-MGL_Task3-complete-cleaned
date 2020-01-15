package com.MGL_Task3.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MGL_Task3.controller.MGL_Endpoint_Constants;
import com.MGL_Task3.dao.GameDao;
import com.MGL_Task3.model.Game;

@Service
public class Game_Service_Impl implements Game_Service {

    private static RestTemplate restTemplate = new RestTemplate();
    private static final String MAIN_URI = "http://localhost:8080/MGL_Task3";

    @Autowired
    private GameDao gameDao;

    @Override
    @Transactional
    public void saveGame(Game game) {
	System.out.println("before BACK END CALL FOR SAVE GAME");
	Game_Service_Impl.restTemplate.postForLocation(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.CREATE_GAME,
		game);
	System.out.println("after BACK END CALL FOR SAVE GAME");
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
	System.out.println("before BACK END CALL FOR update GAME");
	Game_Service_Impl.restTemplate.put(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.UPDATE_GAME, game);
    }

    @Override
    @Transactional
    public Game getGame(Long id) {
	System.out.println("before BACK END CALL FOR get GAME");
	return gameDao.getGame(id);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
	System.out.println("before BACK END CALL FOR delete GAME: " + id);
	Game_Service_Impl.restTemplate.put(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.DELETE_GAME, id);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
	System.out.println("Inside listGames in Game Service in Front end");
	ResponseEntity<Game[]> gameResponseEntity = Game_Service_Impl.restTemplate
		.getForEntity(Game_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.FETCH_ALL_GAMES, Game[].class);

	System.out.println("BACK END CALL FOR FETCH ALL GAMES" + gameResponseEntity.toString());

	System.out.println("response on front end: " + gameResponseEntity.toString());
	System.out.println("response body on front end: " + gameResponseEntity.getBody().toString());

	Game[] games = gameResponseEntity.getBody();

	List<Game> gameList = Arrays.asList(games);

	System.out.println(gameList.toString());

	return gameList;
    }

}