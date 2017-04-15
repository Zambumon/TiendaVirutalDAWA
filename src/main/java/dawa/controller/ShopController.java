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

        Dispatcher dispatcher = new Dispatcher();

        defaultAction = new ShowCatalog(this, dispatcher, "/");
        registerAction(defaultAction);
        registerAction(new LogIn(this, dispatcher, "login"));
        registerAction(new SignUp(this, dispatcher, "signup"));
        registerAction(new LogOut(this, dispatcher, "logout"));
        registerAction(new AddToCart(this, dispatcher, "addtocart"));
    }

    private void registerAction(Action a) {
        actions.put(a.getPath(), a);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String path;
        if (uri.startsWith("shop/")) {
            path = uri.substring(6);
        } else {
            path = uri;
        }
        Action a = actions.get(path);

        if (a == null) {
            a = defaultAction;
        }
        a.doAction(request, response);
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
