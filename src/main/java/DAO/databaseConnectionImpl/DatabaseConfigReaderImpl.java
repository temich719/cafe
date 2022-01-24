package DAO.databaseConnectionImpl;

import DAO.DatabaseConfigReader;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfigReaderImpl implements DatabaseConfigReader {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConfigReaderImpl.class);
    private Properties properties;

    public DatabaseConfigReaderImpl() {
        loadJDBC();
    }

    private void loadJDBC() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("resources//databaseConfig.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            LOGGER.error("File with DB properties wasn't found(IOException)");
        }
    }

    @Override
    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
