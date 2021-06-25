package com.theripe.center.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author TheRipe
 * @create 2021/6/20 17:52
 */
@RestController
public class JdbcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/user/queryAll")
    public List<Map<String,Object>> queryAll() {
        List<Map<String, Object>> lisrt = jdbcTemplate.queryForList("select * from user");
        return lisrt;
    }

    @GetMapping("/user/insert")
    public Object insert(String name, String password) {
        jdbcTemplate.execute("insert into user value (\""+name+"\",\""+password+"\")");
        return true;
    }
}
