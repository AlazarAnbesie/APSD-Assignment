package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {

    public static String printProductJSON(List<Product> product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
    }

    public static String printProductXML(List<Product> product) throws  JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
    }
    public static String printProductCSV(List<Product> product) {
        StringWriter writer = new StringWriter();
        writer.write("productId,name,dateSupplied,quantityInStock,unitPrice\n");
        for (Product p : product) {
            writer.write(p.getProductId() + "," + p.getName() + "," + p.getDateSupplied() + "," + p.getQuantityInStock() + "," + p.getUnitPrice() + "\n");
        }
        return writer.toString();
    }
    public static void main(String[] args) throws JsonProcessingException {

        List<Product> products = new ArrayList<>();
        products.add(new Product(3128874119L,"Banana", LocalDate.of(2023,1,24),124,0.55));
        products.add(new Product(2927458265L,"Apple", LocalDate.of(2022,12,9),18,1.09));
        products.add(new Product(9189927460L,"Carrot", LocalDate.of(2023,3,31),89,2.99));

        Comparator<Product> byName = Comparator.comparing(Product::getName);
        System.out.println("Products sorted by name: ");
        List<Product> sortedProducts = products.stream().sorted(byName).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(printProductJSON(sortedProducts));
        System.out.println("---------------------------------");
        System.out.println("Products in XML format");
        System.out.println(printProductXML(sortedProducts));
        System.out.println("---------------------------------");
        System.out.println("Products in CSV format");
        System.out.println(printProductCSV(sortedProducts));


    }
}
