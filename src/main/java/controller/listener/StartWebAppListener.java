package controller.listener;

import DAO.domain.Page;
import DAO.domain.Product;
import org.apache.log4j.Logger;
import service.ProductService;
import service.exception.ServiceException;
import service.serviceFactory.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.util.List;

import static controller.ControllerStringsStorage.*;

public class StartWebAppListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(StartWebAppListener.class);

    private final ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
    private final ProductService productService = serviceFactory.getProductService();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            LOGGER.info("We got to StartWebAppListener");
            ServletContext servletContext = servletContextEvent.getServletContext();
            Page<Product> page = productService.getPageOfBreads(DEFAULT_PAGE_NUMBER);
            List<Product> products = page.getElements();
            List<String> numbersOfPages = page.getNumbersOfPages();
            servletContext.setAttribute(DEFAULT_PRODUCTS_PAGE, products);
            servletContext.setAttribute(AMOUNT_OF_PAGES_ON_START_APP, numbersOfPages);
            int size = products.size();
            if (size < 10 && size > 6) {
                servletContext.setAttribute(MAIN_DIV_SIZE_IN_PIXELS, MAIN_DIV_SIZE_NINE_PRODUCTS);
            } else if (size < 7 && size > 3) {
                servletContext.setAttribute(MAIN_DIV_SIZE_IN_PIXELS, MAIN_DIV_SIZE_SIX_PRODUCTS);
            } else {
                servletContext.setAttribute(MAIN_DIV_SIZE_IN_PIXELS, MAIN_DIV_SIZE_THREE_PRODUCTS);
            }
        } catch (ServiceException e) {
            LOGGER.error("Can't load default info on start page");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context has been destroyed");
    }
}
