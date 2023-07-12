package com.balieiro.dslist.controller;

import com.balieiro.dslist.dto.GameDTO;
import com.balieiro.dslist.dto.GameListDTO;
import com.balieiro.dslist.dto.GameMinDto;
import com.balieiro.dslist.services.GameListService;
import com.balieiro.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lists")
public class GameListController {

    private GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
