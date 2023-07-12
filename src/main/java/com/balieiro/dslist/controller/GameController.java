package com.balieiro.dslist.controller;

import com.balieiro.dslist.dto.GameDTO;
import com.balieiro.dslist.dto.GameMinDto;
import com.balieiro.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable(name = "id") Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }
}
