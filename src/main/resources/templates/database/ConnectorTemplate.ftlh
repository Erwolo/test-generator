import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseHelper {

    public static DataSource createDatSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("${databaseUrl}");
        ds.setUsername("${databaseLogin}");
        ds.setPassword("${databasePassword}");
        ds.setSchema("${databaseSchema}");

        return ds;
    }
}