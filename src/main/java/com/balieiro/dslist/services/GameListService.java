package com.balieiro.dslist.services;

import com.balieiro.dslist.dto.GameListDTO;
import com.balieiro.dslist.dto.GameMinDto;
import com.balieiro.dslist.entities.GameList;
import com.balieiro.dslist.repositories.GameListRepository;
import com.balieiro.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        var result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
