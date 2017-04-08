package dawa.model.valueObjects.runTime;

/**
 * Created by pedro on 8/04/17.
 */
public abstract class User implements IAccess {

    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
