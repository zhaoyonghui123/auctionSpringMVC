package com.iotek.controller;

import com.iotek.entity.Product;
import com.iotek.entity.Record;
import com.iotek.entity.User;
import com.iotek.service.ProductService;
import com.iotek.service.RecordService;
import com.iotek.service.UserService;
import com.iotek.util.GetDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private RecordService recordService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Object o = userService.queryUserByUserNamePass(userName, password);
        if (o instanceof User){
            User user =(User)o;
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "productList";
        }else{
            request.setAttribute("error",o);
            return "userLogin";
        }
    }
    @RequestMapping("/auction")
    public String aution(HttpServletRequest request){
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.queryById(productId);
        String time = GetDateUtil.getTime();
        System.out.println(time);
        if (time.compareTo(product.getStarttime())>0&&time.compareTo(product.getEndtime())<0){
            Record maxpriceRec = recordService.getMaxprice(productId);
            BigDecimal maxprice;
            if (maxpriceRec==null){
                maxprice=product.getStartprice();
            }else{
                maxprice=maxpriceRec.getAuctionprice();
            }
            List<Record> recordList = recordService.getRecordListByProId(productId);
            request.setAttribute("maxprice",maxprice);
            request.setAttribute("recordList",recordList);
            HttpSession session = request.getSession();
            session.setAttribute("product",product);
            return "auctioning";
        }else{
            request.setAttribute("error","该拍卖品没有开始拍卖或者已经结束");
            return "products";
        }
    }
    @RequestMapping("/addRec")
    public String addRec(HttpServletRequest request){
        HttpSession session = request.getSession();
        Product product = (Product)session.getAttribute("product");
        User user = (User)session.getAttribute("user");
        BigDecimal auctionPrice = new BigDecimal(request.getParameter("auctionPrice"));
        String time = GetDateUtil.getTime();
        recordService.addRecord(product.getProductid(),user.getUserid(),time,auctionPrice,user.getUsername());
        Map<Product, String> productListDeal = productService.getProductListDeal();
        Map<Product, List<Record>> productNotListDeal = productService.getProductNotListDeal();
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("ListDeal",productListDeal);
        servletContext.setAttribute("notDeal",productNotListDeal);
        return "result";
    }
    @RequestMapping("/rigister")
    public String rigister(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String cards = request.getParameter("cards");
        boolean b = userService.addUser(userName, password, phone, cards);
        if (b){
           return  "userLogin";
        }else{
            request.setAttribute("error","用户已存在");
            return "rigister.jsp";
        }
    }

}