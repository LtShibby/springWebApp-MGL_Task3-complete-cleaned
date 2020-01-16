package com.MGL_Task3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MGL_Task3.manager.GameManager;
import com.MGL_Task3.model.Game;

@Controller
public class Game_Controller {

    @Autowired
    private GameManager gameManager;

    @RequestMapping(value = MGL_Endpoint_Constants.GAMES, method = RequestMethod.GET)
    public ModelAndView games() {
	return new ModelAndView("games", "command", new Game());
    }

    @RequestMapping(value = MGL_Endpoint_Constants.FETCH_ALL_GAMES, method = RequestMethod.GET)
    public ResponseEntity<List<Game>> fetchAllGames() {
	return new ResponseEntity<>(gameManager.listGames(), HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.CREATE_GAME, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
	gameManager.saveGame(game);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.UPDATE_GAME, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateGame(@RequestBody Game game) {
	gameManager.updateGame(game);
	return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.DELETE_GAME, method = RequestMethod.PUT)
    public ResponseEntity<Void> deleteGame(@RequestBody String game_id) {
	gameManager.deleteGame((Long.valueOf(game_id)));
	return new ResponseEntity<>(HttpStatus.OK);
    }
}