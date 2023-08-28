package com.example.pokemon.Controllers;

import com.example.pokemon.repository.IPokemon;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PokemonController {
    @Autowired
    private IPokemon dao;

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>>listaPokemon() {
        return ResponseEntity.status(200).body(pokemonService.ListarPokemon());
    }

    @PostMapping
    public ResponseEntity<Pokemon> criarPokemon(@RequestBody Pokemon pokemon) {
        return  ResponseEntity.status(201).body(pokemonService.criarPokemon(pokemon));
    }

    @PutMapping
    public ResponseEntity<Pokemon> editarPokemon(@RequestBody Pokemon pokemon) {
        Pokemon PokemonAtt = dao.save(pokemon);
        return  ResponseEntity.status(201).body(PokemonAtt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPokemon(@PathVariable Integer id){
        dao.deleteById(id.longValue());
        return ResponseEntity.status(204).build();
    }



}


