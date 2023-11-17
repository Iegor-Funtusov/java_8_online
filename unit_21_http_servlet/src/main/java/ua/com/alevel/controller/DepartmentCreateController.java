package ua.com.alevel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.MapUtils;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;
import ua.com.alevel.entity.Department;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class DepartmentCreateController extends HttpServlet {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        try(PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang='en'>");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Create new department");
            printWriter.write("</h1>");
            printWriter.write("<form method='post' action='/unit_21_http_servlet/departments-new'>");
            printWriter.write("<label for='name'>Name:</label><br>");
            printWriter.write("<input type='text' id='name' name='departmentName'/><br><br>");
            printWriter.write("<input type='submit' value='Create'/>");
            printWriter.write("</form>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(201);
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            Department department = new Department();
            parameterMap.forEach((k, v) -> {
                if (k.equals("departmentName")) {
                    String name = v[0];
                    department.setName(name);
                }
            });
            departmentDao.create(department);
        }
        resp.sendRedirect("departments");
    }
}
