package com.MGL_Task3.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task3.model.Game;
import com.MGL_Task3.service.Game_Service;

@Service
public class GameManagerImpl implements GameManager {

    @Autowired
    private Game_Service gameService;

    @Override
    public void saveGame(Game game) {
	gameService.saveGame(game);
    }

    @Override
    public void updateGame(Game game) {
	gameService.updateGame(game);
    }

    @Override
    public Optional<Game> getGame(Long id) {
	return gameService.getGame(id);
    }

    @Override
    public void deleteGame(Long id) {
	gameService.deleteGame(id);
    }

    @Override
    public List<Game> listGames() {
	return gameService.listGames();
    }

}