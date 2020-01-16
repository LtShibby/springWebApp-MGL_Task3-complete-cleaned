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
	gameRepository.save(game);
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
	gameRepository.save(game);
    }

    @Override
    @Transactional
    public Optional<Game> getGame(Long id) {
	return gameRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
	gameRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
	return gameRepository.findAll();
    }

}