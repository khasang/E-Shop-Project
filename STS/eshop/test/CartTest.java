import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.eshop.entity.Product;
import com.eshop.model.cart.Cart;
import com.eshop.model.cart.Item;
import org.junit.Before;

public class CartTest {
	private Cart cart = new Cart();
	private Product product = new Product();
	private final int TEST_ID = 1, TEST_PRICE = 1, TEST_QUANTITY = 1;

	@Before
	public void setUp() throws Exception {
		product.setName("Test Product1");
		product.setId(TEST_ID);
		product.setPrice(TEST_PRICE);
	}

	@Test
	public void testAddtem() {
		cart.addtem(product);
		assertEquals(cart.getQuantityTotal(), TEST_QUANTITY);
	}

	@Test
	public void testDeleteItem() {
		int initialSize = cart.getItems().size();
		cart.addtem(product);
		cart.deleteItem(product);
		assertEquals(cart.getItems().size(), initialSize);
	}

	@Test
	public void testUpdateItem() {
		cart.addtem(product);
		int newQuantity = TEST_QUANTITY + 1;
		cart.updateItem(product, TEST_QUANTITY + 1);
		Item item = cart.findItemByProductId(TEST_ID);
		assertEquals(item.getQuantity(), newQuantity);
	}
}
