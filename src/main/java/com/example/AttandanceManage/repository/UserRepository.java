package com.example.AttandanceManage.repository;

import com.example.AttandanceManage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, Object> map = mapList.get(i);
            User user = new User(
                    Integer.parseInt(map.get("id").toString()),
                    map.get("password").toString(),
                    map.get("name").toString(),
                    map.get("role").toString());
            list.add(user);
        }
        return list;
    }

//    public void insert(User user) {
//        synchronizedSequenceWithMaxId();
//        String sql = "INSERT INTO users(name, password, role) VALUES(?, ?, ?)";
//        jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRole());
//    }
//
//    private void synchronizedSequenceWithMaxId() {
//
//    }
}