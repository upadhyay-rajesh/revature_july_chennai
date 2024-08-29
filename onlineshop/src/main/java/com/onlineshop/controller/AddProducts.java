package com.onlineshop.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.onlineshop.entity.Product;
import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;

@WebServlet("/AddProducts")
public class AddProducts extends HttpServlet {

    //Path where all the images are stored
    private final String UPLOAD_DIRECTORY = "C:\\Users\\RajeshUpadhyay\\eclipse-workspace1\\onlineshop\\src\\main\\webapp\\uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Creating session
        HttpSession session = request.getSession();
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                //Taking all image requests
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                String imageName = null;
                String productName = null;
                String productQuantity = null;
                String productPrice = null;
                String descrip = null;
                String mrpPrice = null;
                String status = null;
                String category = null;

                //SALTCHARS to generate unique code for product
                String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder salt = new StringBuilder();
                Random rnd = new Random();
                while (salt.length() < 3) { // length of the random string.
                    int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                    salt.append(SALTCHARS.charAt(index));
                }
                String code = salt.toString();

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        //Getting image name
                        imageName = new File(item.getName()).getName();
                        //Storing in the specified directory
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + imageName));

                        //Retriving all information from frontend
                        FileItem pName = (FileItem) multiparts.get(0);
                        productName = pName.getString();

                        FileItem price = (FileItem) multiparts.get(1);
                        productPrice = price.getString();

                        FileItem description = (FileItem) multiparts.get(2);
                        descrip = description.getString();

                        FileItem mprice = (FileItem) multiparts.get(3);
                        mrpPrice = mprice.getString();

                        FileItem fstatus = (FileItem) multiparts.get(4);
                        status = fstatus.getString();

                        FileItem pcategory = (FileItem) multiparts.get(5);
                        category = pcategory.getString();

                    }
                }
                
                
                try {
                    int id = 0;
                    String imagePath = UPLOAD_DIRECTORY + imageName;
                    Product product=new Product();
                    product.setActive(code);
                    product.setCode(code);
                    product.setDescription(descrip);
                    product.setId(id);
                    product.setImage(imagePath);
                    product.setImage_name(imageName);
                    product.setMrp_price(mrpPrice);
                    product.setName(productName);
                    product.setPrice(productPrice);
                    product.setProduct_category(category);
                    
                    CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");
                    int i=cService.addProductService(product);
                    
                  
                    //If product inserted sucessfully in the database
                    if (i > 0) {
                        String success = "Product added successfully.";
                        //Adding method in session.
                        session.setAttribute("message", success);
                        //Response send to the admin-add-product.jsp
                        response.sendRedirect("admin-add-product.jsp");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                //If any occur occured
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
    }
}
