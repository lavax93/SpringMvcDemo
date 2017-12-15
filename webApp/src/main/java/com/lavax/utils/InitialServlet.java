package com.lavax.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by LAVAX on 2017/12/15.
 */

/**
 * 没有用到
 */
public class InitialServlet extends HttpServlet {
    protected Logger log = LoggerFactory.getLogger(InitialServlet.class);
    private static final long serialVersionUID = 8550329576989690578L;

    /**
     * Constructor of the object
     */
    public InitialServlet() {
        super();
    }

    /**
     * Destruction of the servlet
     */
    public void destroy() {
        super.destroy();
    }

    /**
     * Initialization of the servlet
     *
     * @throws ServletException
     */
    public void init() throws ServletException {
        log.debug("服务器启动,log4j开始工作");
    }

}
