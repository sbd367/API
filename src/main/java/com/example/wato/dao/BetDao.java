package com.example.wato.dao;

import com.example.wato.model.Bet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BetDao {
    int insertBet(UUID id, Bet bet);

    default int insertBet(Bet bet){
        UUID id = UUID.randomUUID();
        return insertBet(id, bet);
    }
    List<Bet> selectAllBets();
    Optional<Bet> selectBetById(UUID id);
    int deleteBetById(UUID id);
    int updateBetById(UUID id, Bet bet);
}
