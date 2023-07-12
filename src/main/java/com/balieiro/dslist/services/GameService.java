package com.balieiro.dslist.services;

import com.balieiro.dslist.dto.GameDTO;
import com.balieiro.dslist.dto.GameMinDto;
import com.balieiro.dslist.entities.Game;
import com.balieiro.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        var gameDto = new GameDTO(result);
        return gameDto;
    }
}
