package com.pokedexServer.Server.service.pokemon;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.pokedexServer.Server.model.Pokemon;

public class PokemonIniitalizeService  {

    private final JdbcTemplate jdbcTemplate;

    public PokemonIniitalizeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to create a new user in the database
    public int createPokemon(int id, String name) {
        String sql = "INSERT INTO pokemon (id, name) VALUES (?, ?)";
        return jdbcTemplate.update(sql,id, name);
    }

    public Pokemon getPokemonById(int id){
        String sql = "SELECT * FROM pokemon WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(rs.getInt("id"));
            pokemon.setName(rs.getString("name"));
            return pokemon;
        });
    }
}
