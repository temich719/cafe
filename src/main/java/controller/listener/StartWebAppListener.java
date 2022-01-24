package controller.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartWebAppListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(StartWebAppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("atr", "work");//${applicationScope['attributeNames']}
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
