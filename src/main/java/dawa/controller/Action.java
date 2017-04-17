package dawa.controller;

import dawa.model.VOs.LoggedOut;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/11.
 */
public abstract class Action {

    protected ShopController controller;
    protected Dispatcher dispatcher;

    public Action(ShopController controller, Dispatcher dispatcher) {
        this.controller = controller;
        this.dispatcher = dispatcher;
    }

    public abstract void doAction(HttpServletRequest req, HttpServletResponse res);

    protected Registered getRegistered(HttpServletRequest req){
        User auser = getUser(req);
        return !(auser instanceof Registered) ? null : (Registered) auser;
    }

    protected User getUser(HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        if(user == null){
            user = new LoggedOut();
            req.getSession().setAttribute("user", user);
        }
        return user;
    }
}
