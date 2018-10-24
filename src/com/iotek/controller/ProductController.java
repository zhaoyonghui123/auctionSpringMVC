package com.iotek.controller;

import com.iotek.entity.PageBean;
import com.iotek.entity.Product;
import com.iotek.service.ProductService;
import com.iotek.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("productList")
    public String productList(HttpServletRequest request, HttpServletResponse response){
        String index = request.getParameter("pageIndex");
        int pageIndex=1;//当前页码 默认为1
        int pageSize=5;//一页显示的行数
        if (index != null){
            pageIndex=Integer.parseInt(index);
        }
        PageBean<Product> pageBean = productService.getPageBean(pageIndex, pageSize);
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        String url;
        if (admin!=null){
            url="admin";
        }else{
            url="products";
        }
        application.setAttribute("pageBean",pageBean);
        return url;
    }

}