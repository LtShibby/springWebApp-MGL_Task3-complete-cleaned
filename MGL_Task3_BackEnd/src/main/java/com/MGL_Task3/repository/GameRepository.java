package com.MGL_Task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MGL_Task3.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
