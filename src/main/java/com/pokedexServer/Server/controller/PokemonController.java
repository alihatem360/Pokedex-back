package com.pokedexServer.Server.controller;

import com.pokedexServer.Server.service.pokemon.PokemonIniitalizeService;
import org.springframework.beans.factory.annotation.Autowired;


public class PokemonController {
    private final PokemonIniitalizeService pokemonIniitalizeService;

    @Autowired
    public PokemonController(PokemonIniitalizeService pokemonIniitalizeService) {
        this.pokemonIniitalizeService = pokemonIniitalizeService;

    }

    @GetMapping("/createUser")
    public String createUser(@RequestParam String name, @RequestParam String email) {
        int rowsAffected = userService.createUser(name, email);
        return rowsAffected > 0 ? "User created successfully!" : "User creation failed.";
    }
}
