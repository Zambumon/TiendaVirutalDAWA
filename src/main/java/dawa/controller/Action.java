package dawa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/11.
 */
public abstract class Action {

    protected ShopController controller;
    protected Dispatcher dispatcher;
    private String path;

    public Action(ShopController controller, Dispatcher dispatcher, String path) {
        this.controller = controller;
        this.dispatcher = dispatcher;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract void doAction(HttpServletRequest req, HttpServletResponse res);
}
