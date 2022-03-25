package com.example.wato.dao;

import com.example.wato.model.Bet;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeBetDao")
public class FakeBetDataAccessService implements BetDao {
    private  static List<Bet> DB = new ArrayList<>();
    @Override
    public int insertBet(UUID id, Bet bet){
        DB.add(new Bet(id, bet.getBet(), bet.getWagers()));
        return 1;
    }

    @Override
    public List<Bet> selectAllBets() {
        System.out.println(DB);
        return DB;
    };

    @Override
    public Optional<Bet> selectBetById(UUID id) {
        return DB.stream()
                .filter(bet -> bet.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBetById(UUID id){
        Optional<Bet> betMaybe = selectBetById(id);
        if(betMaybe.isEmpty()){
            return 0;
        }
        DB.remove(betMaybe.get());
        return 1;
    }

    @Override
    public int updateBetById(UUID id, Bet bet){
        return selectBetById(id).map(u -> {
            int betToDeleteInd = DB.indexOf(u);
            if(betToDeleteInd >= 0) {
                DB.set(betToDeleteInd, new Bet(id, bet.getBet(), bet.getWagers()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
