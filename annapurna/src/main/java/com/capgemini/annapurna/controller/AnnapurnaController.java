/**
 * 
 */
package com.capgemini.annapurna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.Cart;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.FoodProducts;
import com.capgemini.annapurna.restaurant.entity.Order;
import com.capgemini.annapurna.restaurant.entity.Restaurant;

/**
 * @author ugawari
 *
 */
@Controller
public class AnnapurnaController {

	@Autowired
	private RestTemplate restTemplate;
	private FoodProducts foodProducts;
	private Restaurant restaurant;
	private Address address;
	private Cart cart;
	private Set<FoodProducts> products;
	private Integer count = 0;
	private Integer restaurantId1;

	@RequestMapping("/")
	public String getAllRestaurants(Model model) {
		ResponseEntity<List> entity = restTemplate.getForEntity(
				/* "http://annapurna-restaurant/restaurants" */"http://10.246.92.254:8686/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
	}

	@RequestMapping("/search")
	public String search(Model model, @RequestParam String search) {
		ResponseEntity<Restaurant[]> entity = restTemplate.getForEntity(
				/* "http://annapurna-restaurant/restaurants" */"http://10.246.92.254:8686/restaurants",
				Restaurant[].class);
		List<Restaurant> restaurantlist = Arrays.asList(entity.getBody());
		List<Restaurant> searchedList = new ArrayList<>();
		// List<FoodItem> foodItems = new ArrayList<>();
		for (Restaurant restaurant : restaurantlist) {
			if (restaurant.getName().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			if (restaurant.getAddress().getCity().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			for (FoodItem foodItem : restaurant.getFoodItems()) {
				if (foodItem.getFoodName().equalsIgnoreCase(search))
					searchedList.add(restaurant);
				// foodItems.add(foodItem);
			}
		}
		// System.out.println(foodItems.toString());
		model.addAttribute("list", searchedList);
		return "Home";
	}

	@RequestMapping("/foodItems")
	public String getFoodItemsById(Model model, @RequestParam int restaurantId) {
		ResponseEntity<Restaurant> entity = restTemplate.getForEntity(
				/* "http://annapurna-restaurant/restaurants/" */"http://10.246.92.254:8686/restaurants/" + restaurantId,
				Restaurant.class);
		restaurantId1 = restaurantId;
		restaurant = entity.getBody();
		model.addAttribute("restaurant", entity.getBody());
		return "FoodItems";
	}

	/*
	 * @RequestMapping("/cart/getAll") // /cart/getAll public String
	 * getAllCarts(Model model) { System.out.println("getAll"); ResponseEntity<List>
	 * carts = restTemplate .getForEntity( "http://annapurna-cart/carts"
	 * "http://10.246.92.254:8181/carts", List.class); model.addAttribute("carts",
	 * carts.getBody()); return "GetAllCart"; }
	 */

	@RequestMapping("/cart/addCart")
	public String addCart(/* @RequestParam String restaurantName, */ @RequestParam String foodName,
			@RequestParam double price, @RequestParam int quantity/* ,@RequestParam Address address */, Model model) {
		count++;
		System.out.println(cart);
		if (count == 1) {
			products = new HashSet<FoodProducts>();
			foodProducts = new FoodProducts(foodName, price, quantity);
			products.add(foodProducts);
			cart = new Cart(106, restaurant.getName(), products, price, restaurant.getAddress());
			restTemplate.postForEntity(/* "http://annapurna-cart/carts" */"http://10.246.92.254:8181/carts", cart,
					Cart.class);
			// System.out.println(cart+"before update");
		} else {

			FoodProducts newfoodProducts = new FoodProducts(foodName, price, quantity);
			/*
			 * ResponseEntity<Cart> entity = restTemplate
			 * .getForEntity("http://10.246.92.254:8181/carts/" + cart.getCartId(),
			 * Cart.class);
			 */
			//cart = entity.getBody();
			//products = cart.getProducts();
			products.add(newfoodProducts);
			cart.setProducts(products);
			
			// System.out.println(cart + "before setting for update");
			/*
			 * restTemplate.put( "http://annapurna-cart/carts"
			 * "http://10.246.92.254:8181/carts"+cart.getCartId(), cart, Cart.class);
			 */
			restTemplate.put(/* "http://annapurna-cart/carts" */"http://10.246.92.254:8181/carts/"+cart.getCartId(), cart,
					Cart.class);
			// System.out.println(cart);
		}

		model.addAttribute("restaurantId", restaurant.getRestaurantId());

		ResponseEntity<Cart> entity = restTemplate
				.getForEntity("http://10.246.92.254:8181/carts/" + cart.getCartId() + "", Cart.class);

		 System.out.println(entity.getBody() + "after getting cart"); // cart=
		System.out.println(entity.getBody());
		model.addAttribute("cart",entity.getBody());

		return "GetAllCart";
	}

	private Integer getUniqueId() {
		UUID idOne = UUID.randomUUID();
		int uid = idOne.hashCode();
		return uid;
	}

	/*
	 * @RequestMapping("/cart/getById") public String
	 * getOrderById(@RequestParam("orderId") Integer orderId, Model model) {
	 * ResponseEntity<List> list = restTemplate.getForEntity(
	 * "http://annapurna-order/orders/" "http://10.246.92.254:9090/orders/" +
	 * orderId + " ", List.class); //System.out.println(order.getBody());
	 * model.addAttribute("message", "heyyyyyyyy !!!!"); model.addAttribute("list",
	 * list.getBody()); return "Order"; }
	 */

	@RequestMapping("/cart/submitAddress")
	public String placeOrder(@ModelAttribute Address address1, Model model) {
		address = address1;

		return /* "passMoney" */"selectPaymentGateWay";
	}

	@RequestMapping("/ewallet")
	public String getPassMoneyForm(Model model) {
		model.addAttribute("totalAmount", cart.getTotalAmount());
		return "passMoney";

	}

	@RequestMapping("/cart/passMoneyForm")
	public String deduct(/* @RequestParam Integer profileId, */ @RequestParam Double amount, Model model) {
		restTemplate.put(/* "http://annapurna-ewallet/ewallets/" */ "http://10.246.92.254:7979/ewallets/" + 1
				+ "/pay?currentBalance=" + amount, null);
		model.addAttribute("message", "money deducted and Order placed Successfully!");
		String modeOfPayment = "E-Wallet"; // for now

		Integer id = getUniqueId();
		Order order = new Order(id, modeOfPayment, "pending", cart.getProducts(), cart.getTotalAmount(),
				cart.getRestaurantName(), address, cart.getCartId());
		restTemplate.postForEntity(/* "http://annapurna-order/orders" */"http://10.246.92.254:9090/orders", order,
				Order.class);

		ResponseEntity<List> list1 = restTemplate
				.getForEntity("http://10.246.92.254:9090/orders?cartId=" + cart.getCartId(), List.class);

		model.addAttribute("list", list1.getBody());
		System.out.println(list1.getBody());
		count = 0;
		return "Order";
	}

	@RequestMapping("/cart/placeOrder")
	public String getPlaceOrder(

			@RequestParam("quantity") List<Integer> quantityList, @RequestParam("amount") Double totalAmount,
			Model model) {

		/*
		 * Set<FoodProducts> products = new HashSet<FoodProducts>(); products.add(new
		 * FoodProducts("Brinjal", 234, 12)); orderProducts = products;
		 * 
		 * model.addAttribute("quantity", quantity);
		 * 
		 * Set<FoodProducts> products1 = cart.getProducts(); products.clear();
		 * products.clear(); foodProducts.setQuantity(quantity);
		 * products.add(foodProducts); System.out.println(products);
		 * cart.setTotalAmount(foodProducts.getPrice() * quantity);
		 * cart.setTotalAmount(totalAmount);
		 */
		Iterator iterator = products.iterator();

		while (iterator.hasNext()) {

			FoodProducts product = (FoodProducts) iterator.next();
			int i = 0;
			int j = 0;

			System.out.println(quantityList.get(i).toString());
			String y = quantityList.get(i).toString();
			System.out.println(Integer.parseInt(y));
			j = Integer.parseInt(y);

			i++;
			product.setQuantity(j);
			// System.out.println(product);
		}

		cart.setTotalAmount(totalAmount);
		// System.out.println(quantityList);
		// System.out.println(totalAmount);
		return "AddressForm";
	}

	@RequestMapping("/cart/removeFoodProduct")
	public String removeFromCart(/* @ModelAttribute Cart cart, */@RequestParam("restaurantId") Integer restaurantId,
			@RequestParam("foodName") String foodName, @RequestParam("id") Integer id,
			@RequestParam("cartId") Integer cartId, Model model) {

		// System.out.println(foodName);

		ResponseEntity<Cart> entity1 = restTemplate
				.getForEntity("http://10.246.92.254:8181/carts/" + cart.getCartId() + "", Cart.class);
		cart = entity1.getBody();
		Set<FoodProducts> products = cart.getProducts();

		Set<FoodProducts> products1 = new HashSet();
		Iterator iterator = products.iterator();

		while (iterator.hasNext()) {

			FoodProducts product = (FoodProducts) iterator.next();
			// System.out.println(product.getFoodName());
			if (product.getFoodName().equalsIgnoreCase(foodName)) {
				continue;
			} else {
				products1.add(product);
			}
		}

		// System.out.println(products1);
		cart.setProducts(products1);
		restTemplate.postForEntity(/* "http://annapurna-cart/carts" */"http://10.246.92.254:8181/carts", cart,
				Cart.class);
		ResponseEntity<Cart> entity = restTemplate
				.getForEntity("http://10.246.92.254:8181/carts/" + cart.getCartId() + "", Cart.class);
		// System.out.println(entity.getBody());
		model.addAttribute("cart", entity.getBody());
		model.addAttribute("restaurantId", restaurantId);
		if (cart.getProducts().size() == 0) {
			count = 0;
		} else {
			count = 1;
		}
		return "GetAllCart";
	}

	@RequestMapping("/AddMoneyLink")
	public String depositForm() {
		return "addMoney";
	}

	@RequestMapping("/AddMoneyForm")
	public String deposit(@RequestParam Integer profileId, @RequestParam Double amount, Model model) {
		restTemplate.put(/* "http://annapurna-ewallet/ewallets/" */"http://10.246.92.254:7979/ewallets/" + profileId
				+ "?currentBalance=" + amount, null);
		model.addAttribute("message", "money added Successfully!");
		return "addMoney";
	}

	@RequestMapping("/PassMoneyLink")
	public String deductAmount() {
		return "passMoney";
	}

	@RequestMapping("/StatementForm")
	public String statementForm() {
		return "statements";
	}

	@RequestMapping("/statement/{profileId}")
	public String statement(@RequestParam Integer profileId, Model model) {
		ResponseEntity<List> entity = restTemplate.getForEntity(
				/* "http://annapurna-ewallet/ewallets/statements/" */"http://10.246.92.254:7979/ewallets/statements/"
						+ profileId,
				List.class);
		model.addAttribute("statements", entity.getBody());
		return "statements";
	}

	@RequestMapping("/cancelOrder")
	public String cancelOrder(@RequestParam("orderId") Integer orderId, Model model) {
		System.out.println(orderId);
		restTemplate.delete("http://10.246.92.254:9090/orders/" + orderId + "", Order.class);

		ResponseEntity<List> list1 = restTemplate
				.getForEntity("http://10.246.92.254:9090/orders?cartId=" + cart.getCartId(), List.class);

		model.addAttribute("list", list1.getBody());
		return "Order";

	}

	/*
	 * @RequestMapping("/cart/placeOrder") public String
	 * getPlaceOrder(@ModelAttribute FoodProducts foodProducts,Model model) {
	 * products.clear(); products.add(foodProducts); System.out.println(products);
	 * 
	 * //cart.setTotalAmount(totalAmount); return "AddressForm"; }
	 */

}
