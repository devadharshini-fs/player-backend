package com.devu.playerapp;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerRepository repo;

    public PlayerController(PlayerRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return repo.save(player);
    }

    @GetMapping
    public List<Player> getPlayers() {
        return repo.findAll();
    }
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable int id) {
        repo.deleteById(id);
        return "Player deleted successfully";

    }
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
        player.setId(id);
        return repo.save(player);
    }
}