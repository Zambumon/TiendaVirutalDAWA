package dawa.model.valueObjects.runTime;

/**
 * Created by pedro on 8/04/17.
 */
public abstract class User implements IAcces {

    private Cart carrito;

    public Cart getCarrito() {
        return carrito;
    }

    public void setCarrito(Cart carrito) {
        this.carrito = carrito;
    }
}
