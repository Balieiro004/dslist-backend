package com.balieiro.dslist.controller;

import com.balieiro.dslist.dto.GameDTO;
import com.balieiro.dslist.dto.GameListDTO;
import com.balieiro.dslist.dto.GameMinDto;
import com.balieiro.dslist.dto.ReplacementDTO;
import com.balieiro.dslist.services.GameListService;
import com.balieiro.dslist.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lists")
public class GameListController {

    private GameListService gameListService;
    private GameService gameService;
    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }
    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable(value = "listId") Long listId){
        List<GameMinDto> result = gameService.findByList(listId);
        return result;
    }
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
