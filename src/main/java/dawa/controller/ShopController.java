package dawa.controller;

import dawa.controller.actions.*;
import dawa.model.bussinesLogic.AccountManager;
import dawa.model.dao.api.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cout970 on 2017/04/11.
 */

public class ShopController extends HttpServlet {

    private Map<String, Action> actions = new HashMap<>();
    private Action defaultAction = null;
    private AccountManager accountManager;
    private IDAOUsers daoUsers;
    private IDAOItems daoItems;
    private IDAOOrders daoOrders;

    @Override
    public void init() throws ServletException {
        super.init();
        String host = getServletConfig().getInitParameter("BBDDHost");
        String port = getServletConfig().getInitParameter("BBDDPort");

        IDAOFactory factory = new MongoFactory(host, Integer.parseInt(port));
        daoUsers = factory.getDAOUsers();
        daoItems = factory.getDAOItems();
        daoOrders = factory.getDAOOrders();
        accountManager = new AccountManager(daoUsers);

        Dispatcher dispatcher = new Dispatcher(this);

        defaultAction = new ShowCatalog(this, dispatcher);
        registerAction("/", defaultAction);
        registerAction("login", new LogIn(this, dispatcher));
        registerAction("signup", new SignUp(this, dispatcher));
        registerAction("logout", new LogOut(this, dispatcher));
        registerAction("addtocart", new AddToCart(this, dispatcher));
        registerAction("searchitems", new SearchItems(this, dispatcher));
        registerAction("showitem", new ShowItem(this, dispatcher));
        registerAction("removefromcart", new RemoveFromCart(this, dispatcher));
        registerAction("showcart", new ShowCart(this, dispatcher));
        registerAction("searchusers", new SearchUsers(this, dispatcher));
        registerAction("deleteuser", new RemoveAccount(this, dispatcher));
        registerAction("editstock", new EditStock(this, dispatcher));
        registerAction("checkout", new Checkout(this, dispatcher));
        registerAction("confirm", new Confirm(this, dispatcher));
    }

    private void registerAction(String path, Action a) {
        actions.put(path, a);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {

        String path;
        if (request.getAttribute("route") != null) {
            path = (String) request.getAttribute("route");
        } else {
            path = request.getParameter("route");
        }
        Action action = actions.get(path);
        if (action == null) {
            defaultAction.doAction(request, response);
        } else {
            action.doAction(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public IDAOUsers getDaoUsers() {
        return daoUsers;
    }

    public IDAOItems getDaoItems() {
        return daoItems;
    }

    public IDAOOrders getDaoOrders() {
        return daoOrders;
    }
}
