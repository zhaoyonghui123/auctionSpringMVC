package com.iotek.controller;

import com.iotek.entity.Admin;
import com.iotek.entity.Entity;
import com.iotek.service.AdminService;
import com.iotek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;
	@RequestMapping("/test")
	public String test(Model model){
		/*for (String s : key){
			System.out.println(s);
		}*/
		//System.out.println(entity.getId()+"        "+entity.getName());
		/*System.out.println(entity.getStrList().size());*/
		model.addAttribute("modelKey","modelValue");
		return "test";
	}
	@RequestMapping("/adminLogin")
	public String login(HttpServletRequest request){
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		Object o = adminService.login(userName,password);
		if (o instanceof Admin){
			Admin admin =(Admin)o;
			HttpSession session = request.getSession();
			session.setAttribute("admin",admin);
		return "products";
	}else{
			request.setAttribute("error",o);
			return "adminLogin";
		}
	}
	@RequestMapping("/addProduct")
	public String add(HttpServletRequest request){
		String name = request.getParameter("name");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		BigDecimal floor = new BigDecimal(request.getParameter("floor"));
		String time = request.getParameter("time");
		String endTime = request.getParameter("endTime");
		String img = request.getParameter("img");
		String describe = request.getParameter("describe");
		boolean o = productService.addProduct(name, describe, time, endTime, price, floor, img);
		if (o){
			request.setAttribute("key","添加成功");
		}else{
			request.setAttribute("key","添加失败");
		}
		return "products";

	}
	@RequestMapping("/dele")
	public String dele(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id".trim()));
		try {
			productService.deleteProduct(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "products";
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		BigDecimal floor = new BigDecimal(request.getParameter("floor"));
		String time = request.getParameter("time");
		String endTime = request.getParameter("endTime");
		String img = request.getParameter("img");
		String describe = request.getParameter("describe");
		boolean o = productService.updateProduct(id, name, describe, time, endTime, price, floor, img);

		if (o){
			request.setAttribute("key","添加成功");
		}else{
			request.setAttribute("key","添加失败");
		}
		return "products";
	}

	
}
