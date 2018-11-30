package service;

import DAO.OrderNumberDao;
import entity.OrderNumber;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderNumberServiceImpl implements OrderNumberService {
    @Autowired
    private OrderNumberDao orderNumberDao;

    public void addOrder(long number) {
        orderNumberDao.addOrder(number);
    }

    public OrderNumber getOrderByNumber(long number) {
        return orderNumberDao.getOrderByNumber(number);
    }

    public List<OrderNumber> getAllOrder() {
        return orderNumberDao.getAllOrder();
    }

    public void removeOrder(long number) { orderNumberDao.removeOrder(number); }

    public List<OrderNumber> getAllOrderEqualsDate(String date) {
        return orderNumberDao.getAllOrderEqualsDate(date);
    }

    public List<OrderNumber> getAllOrderMoreDate(String date) {
        return orderNumberDao.getAllOrderMoreDate(date);
    }

    public List<OrderNumber> getAllOrderLessDate(String date) {
        return orderNumberDao.getAllOrderLessDate(date);
    }
}
