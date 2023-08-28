package com.example.pokemon.service;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.repository.IPokemon;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PokemonService {

    private IPokemon repository;

    public PokemonService(IPokemon repository){
        this.repository = repository;
    }

    public List<Pokemon> ListarPokemon(){
        List<Pokemon> lista = repository.findAll();
        return lista;
    }

    public Pokemon criarPokemon(Pokemon pokemon){
        Pokemon novoPokemon = repository.save(pokemon);
        return novoPokemon;
    }

}
