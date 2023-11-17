package ua.com.alevel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;
import ua.com.alevel.entity.Department;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class DepartmentReviewController extends HttpServlet {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
//        resp.sendRedirect("https://stackoverflow.com/questions/71544097/updating-web-xml-when-transitioning-from-java-servlet-4-to-jakarta-servlet-5");
        Collection<Department> departments = departmentDao.findAll();
        try(PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<!DOCTYPE html>");
            printWriter.write("<html lang=\"en\">");
            printWriter.write("<body>");
            printWriter.write("<h1>");
            printWriter.write("Review all departments");
            printWriter.write("</h1>");
            printWriter.write("<table>");
            printWriter.write("<tr>");
            printWriter.write("<th>Id</th>");
            printWriter.write("<th>Name</th>");
            printWriter.write("<th>Delete</th>");
            printWriter.write("<th>Update</th>");
            printWriter.write("</tr>");
            for (Department department : departments) {
                printWriter.write("<tr>");
                printWriter.write("<td>");
                printWriter.write(department.getId().toString());
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write(department.getName());
                printWriter.write("</td>");

                printWriter.write("<td>");
                printWriter.write("<a href=\"/unit_21_http_servlet/departments-delete?id=" + department.getId() + "\">delete</a>");
                printWriter.write("</td>");
                printWriter.write("<td>");
                printWriter.write("<a href=\"/unit_21_http_servlet/departments-update?id=" + department.getId() + "\">update</a>");
                printWriter.write("</td>");

                printWriter.write("</tr>");
            }
            printWriter.write("</table>");
            printWriter.write("<a href=\"/unit_21_http_servlet/departments-new\">New departments</a>");
            printWriter.write("</body>");
            printWriter.write("</html>");
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
