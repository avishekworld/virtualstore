package edu.mum.product.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.mum.product.domain.Catagory;
import edu.mum.product.domain.Product;
import edu.mum.product.service.IProductService;

@Controller
public class ProductController {

	@Autowired
    private IProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAll(Model model) {
    	
        return "product";
    }
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String add(Product product, Catagory category,@RequestParam("file") MultipartFile file,MultipartHttpServletRequest request) {
		
		
		productService.registerProduct(product, category);
		
		//http://stackoverflow.com/questions/20162474/how-do-i-receive-a-file-upload-in-spring-mvc-using-both-multipart-form-and-chunk
		
		if (!file.isEmpty()) 
		{
            try 
            {
            	String path=request.getServletContext().getRealPath("/");

                //making directories for our required path.
                byte[] bytes = file.getBytes();
                File directory=    new File(path+ "/uploads");
                if(!directory.exists())
                	{
                		directory.mkdirs();
                	}
                // saving the file
                String fileName=System.currentTimeMillis()+".jpg";
                File imageFile=new File(directory.getAbsolutePath()+System.getProperty("file.separator")+fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imageFile));
                stream.write(bytes);
                stream.close();
                System.out.println("Product Image Saved in "+imageFile.getAbsolutePath());
            } 
            catch (Exception e) 
            {
            	System.out.println("Product Image Saving Failed "+e);
            }
        }
		
		return "redirect:/product";
	}
	
	
}
