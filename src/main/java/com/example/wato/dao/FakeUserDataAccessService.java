package com.example.wato.dao;

import com.example.wato.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {
    private  static List<User> DB = new ArrayList<>();
    @Override
    public int insertUser(UUID id, User user){
        DB.add(new User(id, user.getUsername(), user.getPassword(), user.getWins(), user.getLoss()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        System.out.println(DB);
        return DB;
    };

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(UUID id){
        Optional<User> userMaybe = selectUserById(id);
        if(userMaybe.isEmpty()){
            return 0;
        }
        DB.remove(userMaybe.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID id, User user){
        return selectUserById(id).map(u -> {
            int userToDeleteInd = DB.indexOf(u);
            if(userToDeleteInd >= 0) {
                DB.set(userToDeleteInd, new User(id, user.getUsername(), user.getPassword(), user.getWins(), user.getLoss()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
