package DAO;

import org.apache.log4j.Logger;

import java.util.Objects;

public abstract class AbstractDAO {

    private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
    protected static ConnectionPool connectionPool;

    public AbstractDAO(ConnectionPool connectionPool1) {
        connectionPool = connectionPool1;
    }

    protected void close(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (Objects.nonNull(autoCloseable)) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }
}
