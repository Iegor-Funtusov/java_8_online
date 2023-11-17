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
import java.util.Optional;

public class DepartmentUpdateController extends HttpServlet {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Department> optionalDepartment = departmentDao.findById(id);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            resp.setStatus(200);
            try(PrintWriter printWriter = resp.getWriter()) {
                printWriter.write("<!DOCTYPE html>");
                printWriter.write("<html lang='en'>");
                printWriter.write("<body>");
                printWriter.write("<h1>");
                printWriter.write("Update department");
                printWriter.write("</h1>");
                printWriter.write("<form method='post' action='/unit_21_http_servlet/departments-update'>");
                printWriter.write("<label for='name'>Name:</label><br>");
                printWriter.write("<input type='text' id='name' name='departmentName' value='" + department.getName() + "'/><br><br>");
                printWriter.write("<input type='hidden' id='id' name='id' value='" + department.getId() + "'/>");
                printWriter.write("<input type='submit' value='Update'/>");
                printWriter.write("</form>");
                printWriter.write("</body>");
                printWriter.write("</html>");
            } catch (Exception e) {
                System.out.println("e = " + e.getMessage());
            }
        } else {
            resp.sendRedirect("departments");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            Department department = new Department();
            parameterMap.forEach((k, v) -> {
                if (k.equals("departmentName")) {
                    String name = v[0];
                    department.setName(name);
                }
                if (k.equals("id")) {
                    Long id = Long.parseLong(v[0]);
                    department.setId(id);
                }
            });
            departmentDao.update(department);
        }
        resp.sendRedirect("departments");
    }
}
