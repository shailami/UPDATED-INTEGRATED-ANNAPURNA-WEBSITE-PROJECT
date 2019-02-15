package com.capgemini.annapurna.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.Cart;
import com.capgemini.annapurna.restaurant.entity.FoodProducts;
import com.capgemini.annapurna.restaurant.entity.Order;
import com.capgemini.annapurna.restaurant.entity.Restaurant;

//@Controller
//@RequestMapping("/cart")
public class CartController {

	/*
	 * @Autowired private RestTemplate restTemplate; private Restaurant restaurant;
	 * private Address address; private Cart cart; private Order order;
	 * 
	 * //@RequestMapping("/getAll")// /cart/getAll public String getAllCarts(Model
	 * model) { System.out.println("getAll"); ResponseEntity<List> carts =
	 * restTemplate.getForEntity("http://localHost:8181/carts", List.class);
	 * System.out.println(carts); model.addAttribute("carts", carts.getBody());
	 * return "GetAllCart"; }
	 * 
	 * 
	 * @RequestMapping("/addCart") public String addCart(@RequestParam String
	 * restaurantName) { System.out.println("restaurantName " + restaurantName);
	 * return "GetAllCart"; }
	 * 
	 * 
	 * //@RequestMapping("/foodItems") public String getFoodItemsById(Model
	 * model, @RequestParam int restaurantId) {
	 * //System.out.println("restaurantId "+restaurantId);
	 * ResponseEntity<Restaurant> entity =
	 * restTemplate.getForEntity("http://localhost:8686/restaurants/"+restaurantId,
	 * Restaurant.class); restaurant=entity.getBody();
	 * model.addAttribute("restaurant", entity.getBody()); return "FoodItems"; }
	 * 
	 * //@RequestMapping("/addCart") public String addCart( @RequestParam String
	 * restaurantName, @RequestParam String foodName,
	 * 
	 * @RequestParam double price, @RequestParam int quantity ,@RequestParam Address
	 * address , Model model) { Set<FoodProducts> products = new
	 * HashSet<FoodProducts>(); products.add(new FoodProducts(foodName, price,
	 * quantity));
	 * 
	 * cart = new Cart(106, restaurant.getName(), products,
	 * price,restaurant.getAddress());
	 * restTemplate.postForEntity("http://localHost:8181/carts", cart, Cart.class);
	 * model.addAttribute("cart", cart); return "GetAllCart"; }
	 * 
	 * 
	 * @RequestMapping("/addCart") public String addCart(@RequestParam String
	 * restaurantName, @RequestParam String foodName, @RequestParam double
	 * price, @RequestParam int quantity, Model model) {
	 * System.out.println("restaurantName "+restaurantName);
	 * 
	 * Set<FoodProducts> products = new HashSet<FoodProducts>(); products.add(new
	 * FoodProducts(foodName, price, quantity));
	 * 
	 * Cart cart = new Cart(106, restaurantName, products, 100, null);
	 * restTemplate.postForEntity("http://localHost:8181/carts", cart, Cart.class);
	 * model.addAttribute("cart", cart); return "GetAllCart"; }
	 * 
	 * 
	 * private Integer getUniqueId() { UUID idOne = UUID.randomUUID(); // String str
	 * = "" + idOne; int uid = idOne.hashCode(); // String filterStr = "" + uid; //
	 * str = filterStr.replaceAll("-", ""); return uid; Integer.parseInt(str) }
	 * 
	 * private static Set<FoodProducts> orderProducts;
	 * 
	 * 
	 * @RequestMapping("/getAll") public String getAllOrders(Model model) {
	 * ResponseEntity<List> list =
	 * restTemplate.getForEntity("http://localhost:9090/orders", List.class);
	 * System.out.println(list); model.addAttribute("message", "heyyyyyyyy !!!!");
	 * model.addAttribute("list", list.getBody()); return "GetAll"; }
	 * 
	 * 
	 * //@RequestMapping("/getById") public String
	 * getOrderById(@RequestParam("orderId") Integer orderId, Model model) {
	 * ResponseEntity<Order> order =
	 * restTemplate.getForEntity("http://localhost:9090/orders/" + orderId + " ",
	 * Order.class); System.out.println(order.getBody());
	 * model.addAttribute("message", "heyyyyyyyy !!!!"); model.addAttribute("Order",
	 * order.getBody()); return "Order"; }
	 * 
	 * //@RequestMapping("/passMoneyForm") public String deduct(@RequestParam
	 * Integer profileId, @RequestParam Double amount, Model model) {
	 * restTemplate.put("http://localhost:7979/ewallets/" + profileId +
	 * "/pay?currentBalance=" + amount, null); model.addAttribute("message",
	 * "money deducted and Order placed Successfully!"); String modeOfPayment =
	 * "E-Wallet"; // for now Double totalAmount = 100.0; // for now String
	 * restaurantName = "GrandMama's Cafe"; // for now Integer id = getUniqueId();
	 * order = new Order(id, modeOfPayment, "pending", cart.getProducts(),
	 * cart.getTotalAmount(), cart.getRestaurantName(), address, cart.getCartId());
	 * 
	 * restTemplate.put("http://localhost:7979/ewallets/" + 1 + "?currentBalance=" +
	 * 100.0, null);
	 * 
	 * // deposit(1, totalAmount, model); ResponseEntity<Order> order1 =
	 * restTemplate.postForEntity("http://localhost:9090/orders", order,
	 * Order.class); // model.addAttribute("message", "heyyyyyyyy !!!!");
	 * model.addAttribute("Order", order1.getBody());
	 * 
	 * model.addAttribute("profileId", 1); model.addAttribute("amount",totalAmount
	 * );
	 * 
	 * return "Order"; }
	 * 
	 * //@RequestMapping("/placeOrder") public String getPlaceOrder( @RequestBody
	 * Cart cart, Model model) { // Set<FoodProducts> products =cart.getProducts();
	 * // Double totalAmount=cart.getTotalAmount(); // String
	 * restaurantName=cart.getRestaurantName(); Set<FoodProducts> products = new
	 * HashSet<FoodProducts>(); products.add(new FoodProducts("Brinjal", 234, 12));
	 * orderProducts = products; // model.addAttribute("products", products); return
	 * "AddressForm";
	 * 
	 * 
	 * Address address=new Address(65, "rosa villa", "Mumbai", 65423, "Maharashtra",
	 * "India"); Order order = new Order(156, "COD", "Delivered", products, 1000.00,
	 * 123, "grandmama", address, 543); ResponseEntity<Order>
	 * order1=restTemplate.postForEntity("http://localhost:9090/orders", order,
	 * Order.class); model.addAttribute("message", "heyyyyyyyy !!!!");
	 * model.addAttribute("Order",order1.getBody()); return "Order";
	 * 
	 * }
	 * 
	 * //@RequestMapping("/submitAddress") public String placeOrder(@ModelAttribute
	 * Address address1, Model model) { // PaymentGateway // Ewallet
	 * e-wallet=restTemplate.postForEntity(url, request, // responseType);//calling
	 * e-wallet API // String modeOfPayment=e-wallet.getBody().getMOdeOfPayment();
	 * address=address1; return "passMoney"; }
	 * 
	 * 
	 * @RequestMapping("/submitAddress") public String placeOrder(@ModelAttribute
	 * Address address, Model model) { // PaymentGateway // Ewallet
	 * e-wallet=restTemplate.postForEntity(url, request, // responseType);//calling
	 * e-wallet API // String modeOfPayment=e-wallet.getBody().getMOdeOfPayment();
	 * String modeOfPayment = "COD"; // for now Double totalAmount = 100.0; // for
	 * now String restaurantName = "GrandMama's Cafe"; // for now Integer id =
	 * getUniqueId(); Order order = new Order(id, modeOfPayment, "pending",
	 * orderProducts, totalAmount, restaurantName, address, 543);
	 * ResponseEntity<Order> order1 =
	 * restTemplate.postForEntity("http://localhost:9090/orders", order,
	 * Order.class); model.addAttribute("message", "heyyyyyyyy !!!!");
	 * model.addAttribute("Order", order1.getBody()); return "Order"; }
	 * 
	 * 
	 * //@RequestMapping("/updateStatus") public String
	 * updateStatus(@RequestParam("orderId") Integer
	 * orderId, @RequestParam("status") String updatedStatus, Model model) {
	 * restTemplate.put("http://localhost:9090/orders/" + orderId + "?status=" +
	 * updatedStatus + "", null); ResponseEntity<Order> order =
	 * restTemplate.getForEntity("http://localhost:9090/orders/" + orderId + " ",
	 * Order.class); System.out.println(order.getBody());
	 * model.addAttribute("message", "heyyyyyyyy !!!!"); model.addAttribute("Order",
	 * order.getBody()); return "Order"; }
	 * 
	 * 
	 * @RequestMapping("/cancelOrder") public String
	 * cancelOrder(@RequestParam("orderId") Integer orderId, Model model) {
	 * restTemplate.delete("http://localhost:9090/orders/" + orderId + "");
	 * getAllOrders(model); return "GetAll";
	 * 
	 * }
	 */

}
