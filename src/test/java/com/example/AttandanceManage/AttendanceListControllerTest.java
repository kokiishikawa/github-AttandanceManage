package com.example.AttandanceManage;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
class AttendanceListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

        @Test
        public void index() throws Exception {
            mockMvc.perform(get("/attendanceList"))
                    .andExpect(content().string(containsString("21:13:28")))
                    .andExpect(content().string(containsString("22:16:14")));
        }

        @Test
        public void attendanceInput() throws Exception {
            String expectedTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            mockMvc.perform(post("/attendanceInput"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
//                    .andExpect(redirectedUrl("attendanceInput"))
                    .andExpect(content().string(containsString("出勤")))
                    .andExpect(content().string(Matchers.not(containsString("出勤出勤"))));
            String sql = "SELECT COUNT(*) FROM attendances WHERE begin_time = '" + expectedTime + "'";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);
            assertEquals(1, count);
        }
}