package com.example.wato.api;

import com.example.wato.model.Bet;
import com.example.wato.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/bet")
@RestController
public class BetController {
    private final BetService betService;

    @Autowired
    public BetController(BetService betService){
        this.betService = betService;
    }
    @CrossOrigin
    @PostMapping
    public void addBet(@RequestBody Bet bet) {
        System.out.println(bet.getWagers());
        betService.addBet(bet);
    }
    @CrossOrigin
    @GetMapping
    public List<Bet> getAllBets(){
     return betService.getBets();
    }
    @CrossOrigin
    @GetMapping(path = "{id}")
    public Bet getBetById(@PathVariable("id") UUID id) {
         return betService.getBetById(id).orElse(null);
    }
    @CrossOrigin
    @PutMapping(path = "{id}")
    public void updateBet(@PathVariable("id") UUID id, @RequestBody Bet betToUpdate){
        System.out.println("Ran");
        betService.updateBet(id, betToUpdate);
    }
    @CrossOrigin
    @DeleteMapping(path = "{id}")
    public void deleteBetById(@PathVariable("id") UUID id){
        betService.deleteBet(id);
    }
}
