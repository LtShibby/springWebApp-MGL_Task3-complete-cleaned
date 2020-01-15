package com.MGL_Task3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task3.model.Game;
import com.MGL_Task3.repository.GameRepository;

@Service
public class Game_Service_Impl implements Game_Service {

    @Autowired
    private GameRepository gameRepository;

    @Override
    @Transactional
    public void saveGame(Game game) {
	System.out.println("About to call repository.save for game in back end");
	System.out.println();
	gameRepository.save(game);
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
	System.out.println("About to call repository.save for update for game in back end");
	System.out.println();
	gameRepository.save(game);
    }

    @Override
    @Transactional
    public Optional<Game> getGame(Long id) {
	System.out.println("About to call repository.getOne for game in back end");
	System.out.println();
	return gameRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
	System.out.println("About to call repository.delete for game in back end");
	System.out.println();
	gameRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
	System.out.println("About to call repository.findAll for game in back end");
	System.out.println();
	return gameRepository.findAll();
    }

}