package vn.edu.funix.lanltfx01326.bookstore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import vn.edu.funix.lanltfx01326.bookstore.model.Book;

@Service
public class ShoppingCartService {

	@Value("${shipping.costs}")
	private String shippingCosts;
	private HttpSession session;

	public ShoppingCartService(HttpSession session) {
		this.session = session;
	}

	public List<Book> getCart() {
		List<Book> cart = (List<Book>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<>();
		}
		return cart;
	}

	public BigDecimal totalPrice() {
		BigDecimal shipping = new BigDecimal(shippingCosts);
		BigDecimal totalPriceWithShipping = new BigDecimal(0);
		List<Book> cart = getCart();
		for (Book b : cart) {
			totalPriceWithShipping = totalPriceWithShipping.add(b.getPrice());
		}
		totalPriceWithShipping = totalPriceWithShipping.add(shipping);
		return totalPriceWithShipping;
	}

	public void emptyCart() {
		List<Book> cart = getCart();
		cart.removeAll(cart);
	}

	public void deleteProductWithId(Long bookId) {
		List<Book> cart = getCart();
		cart.removeIf(b -> b.getId().equals(bookId));
	}

	public String getshippingCosts() {
		return shippingCosts;
	}

	public HttpSession getSession() {
		return session;
	}

}
