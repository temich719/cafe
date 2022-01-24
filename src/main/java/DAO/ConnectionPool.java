package DAO;

import DAO.exception.DAOException;

import java.sql.Connection;

public interface ConnectionPool {
    Connection provide()throws DAOException;

    void retrieve(Connection connection);
}
