package com.example.pokemon.DAO;

import com.example.pokemon.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemon extends CrudRepository<Pokemon, Long> {}
