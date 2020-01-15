package com.MGL_Task3.service;

import java.util.List;

import com.MGL_Task3.model.Game;

public interface Game_Service {

    void saveGame(Game game);

    void updateGame(Game game);

    Game getGame(Long id);

    void deleteGame(Long id);

    List<Game> listGames();

}
