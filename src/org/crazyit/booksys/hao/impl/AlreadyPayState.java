package org.crazyit.booksys.hao.impl;

import org.crazyit.booksys.dao.OrderDao;
import org.crazyit.booksys.domain.Order;
import org.crazyit.booksys.hao.OrderState;

public class AlreadyPayState extends OrderState {
	
	public AlreadyPayState(Order order, OrderDao orderDao) {
		super(order, orderDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void editAddress() {
		// TODO Auto-generated method stub
		System.out.println("已确认");
	}

	@Override
	public void userCancelOrder() {
		// TODO Auto-generated method stub
		System.out.println("已支付，不可取消");
	}

	@Override
	public void payOrder() {
		// TODO Auto-generated method stub
		System.out.println("已支付");
	}

	@Override
	public void requestRefund(String reason) {
		// TODO Auto-generated method stub
		order.setOrderState("申请退货");
		order.setOrderStateReason(reason);
		orderDao.update(order);
	}

	@Override
	public void takeBooks() {
		// TODO Auto-generated method stub
		System.out.println("未发货");
	}

	@Override
	public void evaluationOrder(String orderEvaluation) {
		// TODO Auto-generated method stub
		System.out.println("未确认收货");
	}

	@Override
	public void notAcceptOrder() {
		// TODO Auto-generated method stub
		order=orderDao.addAmount(order);
		order.setOrderState("交易结束");
		order.setOrderStateReason("卖家不接单");
		orderDao.update(order);
	}

	@Override
	public void acceptOrder() {
		// TODO Auto-generated method stub
		order.setOrderState("未发货");
		orderDao.update(order);
	}

	@Override
	public void cancelOrder() {
		// TODO Auto-generated method stub
		System.out.println("未接单");
	}

	@Override
	public void sendBooks() {
		// TODO Auto-generated method stub
		System.out.println("未接单");
	}

	@Override
	public void acceptRefund() {
		// TODO Auto-generated method stub
		System.out.println("未接单");
	}
	
}
