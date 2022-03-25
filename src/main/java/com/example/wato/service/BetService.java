package com.example.wato.service;

import com.example.wato.dao.BetDao;
import com.example.wato.dao.UserDao;
import com.example.wato.model.Bet;
import com.example.wato.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BetService {
    private final BetDao betDao;
    public BetService(@Qualifier("fakeBetDao") BetDao betDao){
        this.betDao = betDao;
    }

    public int addBet(Bet bet) {
        return betDao.insertBet(bet);
    }
    public int deleteBet(UUID id){
        return betDao.deleteBetById(id);
    }
    public List<Bet> getBets(){
        return betDao.selectAllBets();
    }
    public Optional<Bet> getBetById(UUID id){
        return betDao.selectBetById(id);
    }
    public int updateBet(UUID id, Bet bet){
        return betDao.updateBetById(id, bet);
    }
}
