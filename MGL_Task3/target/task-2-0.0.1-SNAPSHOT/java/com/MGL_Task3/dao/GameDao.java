package com.MGL_Task3.dao;

import java.util.List;

import com.MGL_Task3.model.Game;

public interface GameDao {

    Game saveGame(Game game);

    Game updateGame(Game game);

    Game getGame(Long id);

    Game deleteGame(Long id);

    List<Game> listGames();

}