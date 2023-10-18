package com.example.demo;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.impl.CustomerDAOImpl;
import com.example.demo.entity.CustomerEntity;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private CustomerDAO customerDAO;

    public void init() {
        message = "Hello World!";
        customerDAO = new CustomerDAOImpl();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        CustomerEntity customerEntity = new CustomerEntity("T2203E FPT",25,"B6");
        request.setAttribute("customer", customerEntity);
        List<CustomerEntity> customerEntityList= customerDAO.getAllCustomer();
        request.setAttribute("customers", customerEntityList);
        request.getRequestDispatcher("/demoJsp.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test Attribute", "TestAttributeValue");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test-servlet");
        dispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {

    }
}