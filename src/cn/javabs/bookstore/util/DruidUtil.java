package cn.javabs.bookstore.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DruidUtil {
    public static DataSource dataSource;

    static {
        try {
            InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties p = new Properties();
            p.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            throw new  RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return  dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }
}
