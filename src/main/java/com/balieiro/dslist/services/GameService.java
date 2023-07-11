package com.balieiro.dslist.services;

import com.balieiro.dslist.dto.GameMinDto;
import com.balieiro.dslist.entities.Game;
import com.balieiro.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
}
