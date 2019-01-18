package pl.robson.database.dbutils;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.robson.database.modele.Paliwo;
import pl.robson.database.modele.Pojazd;
import pl.robson.database.modele.Firma;
import pl.robson.database.modele.TypPojazdu;
import java.io.IOException;
import java.sql.SQLException;
import pl.robson.database.modele.PobierajacyInne;
import pl.robson.database.modele.Ubezpieczenie;
import pl.robson.database.modele.paliwoInne;

public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./RobsonDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnectionSource();
       // dropTable();
        createTable();
        closeConnectionSource();
      
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD,USER, PASS);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, Paliwo.class);
            TableUtils.createTableIfNotExists(connectionSource, Pojazd.class);
            TableUtils.createTableIfNotExists(connectionSource, TypPojazdu.class);
            TableUtils.createTableIfNotExists(connectionSource, Firma.class);
            TableUtils.createTableIfNotExists(connectionSource, PobierajacyInne.class);
            TableUtils.createTableIfNotExists(connectionSource, paliwoInne.class);
            TableUtils.createTableIfNotExists(connectionSource, Ubezpieczenie.class);



        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private  static  void  dropTable(){
        try {
            TableUtils.dropTable(connectionSource, Paliwo.class,true);
            TableUtils.dropTable(connectionSource, Pojazd.class,true);
            TableUtils.dropTable(connectionSource, TypPojazdu.class,true);
            TableUtils.dropTable(connectionSource, Firma.class,true);
            TableUtils.dropTable(connectionSource, PobierajacyInne.class,true);
            TableUtils.dropTable(connectionSource, paliwoInne.class,true);
            TableUtils.dropTable(connectionSource, Ubezpieczenie.class,true);


        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
