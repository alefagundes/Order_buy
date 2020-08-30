package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enuns.OrderStatus;

public class Order {
		private static SimpleDateFormat sdf = new SimpleDateFormat();
		private Date moment;
		private OrderStatus status;
		
		private Client client;
		private List<OrderItem> items = new ArrayList<>();
		
		public Order() {
		}

		public Order(Date moment, OrderStatus status, Client client) {
			this.moment = moment;
			this.status = status;
			this.client = client;
		}

		public static SimpleDateFormat getSdf() {
			return sdf;
		}

		public static void setSdf(SimpleDateFormat sdf) {
			Order.sdf = sdf;
		}

		public Date getMoment() {
			return moment;
		}

		public void setMoment(Date moment) {
			this.moment = moment;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public Client getClient() {
			return client;
		}
		public List<OrderItem> getItem(){
			return items;
		}

		public void setClient(Client client) {
			this.client = client;
		}
		
		public void addItem(OrderItem item) {
			items.add(item);
		}
		public void remove(OrderItem item) {
			items.remove(item);
		}
		
		public double valueTotal() {
			double sum = 0.0;
			for(OrderItem it : items) {
				sum += it.subTotal();
			}
			return sum;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("ORDER MOMENT: ");
			sb.append(sdf.format(moment) + "\n");
			sb.append("Order status: ");
			sb.append(status + "\n");
			sb.append("Client: ");
			sb.append(client + "\n");
			sb.append("Order items:" + "\n");
			for (OrderItem it : items) {
				sb.append(it +"\n");
			}
			sb.append("Total Price: $");
			sb.append(String.format("%.2f", valueTotal()));
			return sb.toString();
		}
		
		
		
}
