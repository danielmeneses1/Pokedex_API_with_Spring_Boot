package com.example.pokemon.Controllers;

import com.example.pokemon.DAO.IPokemon;
import com.example.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping
    public Pokemon editarPokemon(@RequestBody Pokemon pokemon) {
        Pokemon PokemonAtt = dao.save(pokemon);
        return  PokemonAtt;
    }

    @DeleteMapping("/{id}")
    public Optional<Pokemon> excluirPokemon(@PathVariable Integer id){
        Optional<Pokemon> pokemon = dao.findById(id.longValue());
        dao.deleteById(id.longValue());
        return pokemon;
    }



}


