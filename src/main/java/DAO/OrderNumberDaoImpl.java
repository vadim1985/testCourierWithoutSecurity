package DAO;

import entity.OrderNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderNumberDaoImpl implements OrderNumberDao {
    private static final String SQL_INSERT_NEW_ORDER = "INSERT INTO calltask (orderNumber, date) VALUES (?, ?)";
    public static final String SQL_SELECT_ALL_ORDER = "SELECT orderNumber, date FROM calltask ORDER BY orderNumber";
    private static final String SQL_SELECT_ORDER_BY_NAME = "SELECT orderNumber, date FROM calltask WHERE orderNumber = ?";
    private static final String SQL_DELETE_ORDER = "DELETE FROM calltask WHERE orderNumber = ?";
    private static final String SQL_SELECT_ALL_ORDER_EQUALS_DATE = "SELECT orderNumber, date FROM calltask WHERE date > ? and date < ? ORDER BY orderNumber";
    private static final String SQL_SELECT_ALL_ORDER_MORE_DATE = "SELECT orderNumber, date FROM calltask WHERE date > ? ORDER BY orderNumber";
    private static final String SQL_SELECT_ALL_ORDER_LESS_DATE = "SELECT orderNumber, date FROM calltask WHERE date < ? ORDER BY orderNumber";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderNumberDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addOrder(long number) {
            Date date = new Date();
            DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            jdbcTemplate.update(SQL_INSERT_NEW_ORDER, number, formatDate.format(date));
    }

    public OrderNumber getOrderByNumber(long number) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORDER_BY_NAME, new RowMapper<OrderNumber>() {
                public OrderNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return getOrderNumber(rs);
                }
            }, number);
        }catch (Exception e){
            return null;
        }
    }

    public List<OrderNumber> getAllOrder() {
    return jdbcTemplate.query(SQL_SELECT_ALL_ORDER, new RowMapper<OrderNumber>() {
        public OrderNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
            return getOrderNumber(rs);
        }
    });
    }

    public List<OrderNumber> getAllOrderEqualsDate(String date) {
        String firstDate = date + " 00:00:00";
        String secondDate = date + " 59:59:59";
        return jdbcTemplate.query(SQL_SELECT_ALL_ORDER_EQUALS_DATE, new RowMapper<OrderNumber>() {
            public OrderNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getOrderNumber(rs);
            }
        }, firstDate, secondDate);
    }

    public List<OrderNumber> getAllOrderMoreDate(String date) {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORDER_MORE_DATE, new RowMapper<OrderNumber>() {
            public OrderNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getOrderNumber(rs);
            }
        }, date);
    }

    public List<OrderNumber> getAllOrderLessDate(String date) {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORDER_LESS_DATE, new RowMapper<OrderNumber>() {
            public OrderNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
                return getOrderNumber(rs);
            }
        }, date);
    }

    public void removeOrder(long number) {
        jdbcTemplate.update(SQL_DELETE_ORDER, number);
    }

    private OrderNumber getOrderNumber(ResultSet set){
        OrderNumber orderNumber = new OrderNumber();
        try {
            orderNumber.setNumber(set.getLong("orderNumber"));
            orderNumber.setDate(set.getDate("date"));
        }catch (SQLException e){
            System.out.println("--getOrderNumber exception--");
            System.out.println(e.getMessage());
        }
        return orderNumber;
    }
}
