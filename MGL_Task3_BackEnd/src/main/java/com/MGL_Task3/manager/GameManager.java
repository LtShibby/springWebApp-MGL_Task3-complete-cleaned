package com.MGL_Task3.manager;

import java.util.List;
import java.util.Optional;

import com.MGL_Task3.model.Game;

public interface GameManager {

    void saveGame(Game game);

    void updateGame(Game game);

    Optional<Game> getGame(Long id);

    void deleteGame(Long id);

    List<Game> listGames();

}
