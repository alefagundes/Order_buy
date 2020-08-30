package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enther Client Data:");
		System.out.print("Name:");
		String nameClient = sc.nextLine();
		System.out.print("Email:");
		String emailClient = sc.nextLine();
		System.out.print("Birth date(dd/mm/yy)");
		Date clientDate = sdf.parse(sc.next());
		Client client = new Client(nameClient, emailClient, clientDate);
		System.out.println("Enter order data:");
		System.out.print("STATUS:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		System.out.print("How many items to this order?:");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name:");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price:");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity:");
			int quantityPedido = sc.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);
			OrderItem it = new OrderItem(quantityPedido, priceProduct, product);
			order.addItem(it);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
	}

}
