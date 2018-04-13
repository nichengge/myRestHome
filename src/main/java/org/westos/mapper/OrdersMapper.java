package org.westos.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.westos.entity.Orders;
import org.westos.entity.OrdersExample;

public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    // -------
 	List<Orders> selectOrderByPage(@Param("begin") Integer begin, @Param("count") Integer count,
 			@Param("orders") Orders orders);

 	int selectAllLine(@Param("orders") Orders orders);
 	
 	Orders selectOrderById(@Param("id") Integer id);
}