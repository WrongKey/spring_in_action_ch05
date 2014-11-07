package com.wrongkey.spitter.DAO;

import com.wrongkey.spitter.Person;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wrongkey
 * @version v1.0
 * @description JdbcTemplate实现数据访问
 * @date 2014/11/7
 */
public class JdbcTemplatePersonImpl implements PersonDao {
    private static final String SQL_INSERT_PERSON =
            "insert into persons (Id_P,LastName,FirstName,Address,City) value (?,?,?,?,?)";
    private static final String SQL_UPDATE_PERSON =
            "update persons set LastName = ?, FirstName = ?, Address = ?, City = ?" +
                    "where Id_P = ?";
    private static final String SQL_SELECT_PERSON = "select Id_P,LastName,FirstName," +
            "Address,City from persons where Id_P = ?";

    private SimpleJdbcTemplate jdbcTemplate;

    /**
     * @author wrongkey
     * @description 注入jdbcTemplate
     * @date 2014/11/7
     * @version v1.0
     */
    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPerson(Person person) {
        jdbcTemplate.update(SQL_INSERT_PERSON, person.getId(), person.getLastName(),
                person.getFirstName(), person.getAddress(), person.getCity());
    }

    @Override
    public void savePerson(Person person) {

    }

    @Override
    public Person getPersonById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_PERSON,new ParameterizedBeanPropertyRowMapper<Person>(){
            public Person mapRow(ResultSet rs,int rowNum) throws SQLException{
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setLastName(rs.getString(2));
                person.setFirstName(rs.getString(3));
                person.setAddress(rs.getString(4));
                person.setCity(rs.getString(5));
                return person;
            }
        },
        id
        );
    }
}
