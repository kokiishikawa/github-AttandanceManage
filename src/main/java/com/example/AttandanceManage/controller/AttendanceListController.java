package com.example.AttandanceManage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AttendanceListController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/attendanceList")
    public String index(Model model) {
//        データベースのレコードを取得
        String sql = "SELECT * FROM attendances";
//        データを変数listに代入
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        データ受け渡し
        model.addAttribute("attendancelist", list);

        return "attendance_list";
    }

    @PostMapping("/attendanceInput")
    public String attendanceInput() {

//        出勤時間取得
        Date nowDate = new Date();
//        フォーマット指定
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        String nowTime = sdf1.format(nowDate);
//        出勤時間をlogで表示
        System.out.println("取得時間:" + nowTime);

//        データベースにINSERT
        String sql = "INSERT INTO attendances (begin_time) values (?::time)";
        jdbcTemplate.update(sql, nowTime);

        return "index";
    }
}
