package com.theripe.center;

import com.theripe.center.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class CenterApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void dataSourceTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection != null);
        connection.close();

    }
    @Test
    public void mm() {
        System.out.println(MD5Util.MD5Encode("5201314", "UTF-8"));
    }

}
