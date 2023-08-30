package com.ecommerce.clthr.service;

import com.ecommerce.clthr.dto.ProductRepository;
import com.ecommerce.clthr.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void saveProductToDB(MultipartFile image, String name, int price, String description) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
        }
        try {
            product.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        productRepository.save(product);
    }

    public void editProduct(long id, MultipartFile image, String name, int price, String description) {
        Product product = new Product();
        product = productRepository.findById(id).get();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        if (image != null && !image.isEmpty()) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("not a valid file");
            }
            try {
                product.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productRepository.save(product);
    }
}
