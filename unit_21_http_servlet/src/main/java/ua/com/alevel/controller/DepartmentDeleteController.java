package ua.com.alevel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;

import java.io.IOException;

public class DepartmentDeleteController extends HttpServlet {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        departmentDao.delete(id);
        resp.sendRedirect("departments");
    }
}
