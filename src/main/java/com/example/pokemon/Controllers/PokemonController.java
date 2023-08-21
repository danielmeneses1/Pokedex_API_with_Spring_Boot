package com.example.pokemon.Controllers;

import com.example.pokemon.DAO.IPokemon;
import com.example.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping

public class PokemonController {

    private final IPokemon dao;

    @Autowired
    public PokemonController(IPokemon dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Pokemon> listaPokemon() {
        return (List<Pokemon>) dao.findAll();
    }

    @PostMapping
    public Pokemon criarPokemon(@RequestBody Pokemon pokemon) {
        Pokemon novoPokemon = dao.save(pokemon);
        return  novoPokemon;
    }
}


