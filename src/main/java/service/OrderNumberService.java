package service;

import entity.OrderNumber;

import java.util.List;

public interface OrderNumberService {
    void addOrder(long number);
    OrderNumber getOrderByNumber(long number);
    List<OrderNumber> getAllOrder();
    void removeOrder(long number);
    List<OrderNumber> getAllOrderEqualsDate(String date);
    List<OrderNumber> getAllOrderMoreDate(String date);
    List<OrderNumber> getAllOrderLessDate(String date);
}
