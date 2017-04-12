package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
@SuppressWarnings("unused")
public abstract class User implements IAccess {

    private Cart cart;

    public User() {
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
