package com.wrongkey.spitter.DAO;

import com.wrongkey.spitter.Person;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wrongkey
 * @version v1.0
 * @description
 * @date 2014/11/6
 */
public class PersonDaoIpml implements PersonDao {
    private static final String SQL_INSERT_PERSON =
            "insert into persons (Id_P,LastName,FirstName,Address,City) value (?,?,?,?,?)";
    private static final String SQL_UPDATE_PERSON =
            "update persons set LastName = ?, FirstName = ?, Address = ?, City = ?" +
                    "where Id_P = ?";
    private static final String SQL_SELECT_PERSON = "select Id_P,LastName,FirstName," +
            "Address,City from persons where Id_P = ?";

    private DriverManagerDataSource dataSource;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addPerson(Person person) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PERSON);

            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getFirstName());
            stmt.setString(4, person.getAddress());
            stmt.setString(5, person.getCity());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void savePerson(Person person) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_PERSON);

            stmt.setString(1, person.getLastName());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getAddress());
            stmt.setString(4, person.getCity());
            stmt.setInt(5, person.getId());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public Person getPersonById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Person person = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PERSON);

            stmt.setInt(1, id);
            rs = stmt.executeQuery();


            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("Id_P"));
                person.setLastName(rs.getString("LastName"));
                person.setFirstName(rs.getString("FirstName"));
                person.setAddress(rs.getString("Address"));
                person.setCity(rs.getString("City"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return person;
    }
}
