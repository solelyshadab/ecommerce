package com.baig.ecommerce.config;

import com.baig.ecommerce.CIFData.CIFDataRepository;
import com.baig.ecommerce.product.ProductMaster;
import com.baig.ecommerce.product.ProductMasterRepository;
import com.baig.ecommerce.productcatalogue.Product;
import com.baig.ecommerce.productcatalogue.ProductCatalogue;
import com.baig.ecommerce.productcatalogue.ProductCatalogueRepository;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.*;

@EnableMongoRepositories(basePackageClasses = {ProductCatalogueRepository.class, ProductMasterRepository.class
, CIFDataRepository.class})

@Configuration
public class AppConfiguration {

        @Bean
        CommandLineRunner commandLineRunner(ProductCatalogueRepository productCatalogueRepository,
                                            ProductMasterRepository productMasterRepository){
        return args -> {
            //productCatalogueRepository.deleteAll();
            String[] catAndSubcategories = {"electronics_mobile_accesories_laptops",
                    "appliances_washing machine_kitchen appliances",
                    "men_clothing_foot wear_watches",
                    "women_western wear_ethinc wear_foot wear",
                    "kids_clothing_foot wear_toys",
                    "furniture_home decor_kitchen_lighting"};
            Product[] products = new Product[10000];

            for(int i = 0; i < 10000; i++){
                Product product=new Product( i, "ProductName: " +i, "Product " + i + " Description" , "product " + i+" path");
                ProductMaster productMaster=new ProductMaster( i, "ProductName: " +i, "Product " + i + " Description" , "product " + i+" path");
                products[i] = product;
                productMasterRepository.save(productMaster);
            }
            int start = 0; int range = (products.length / 18)-1;
            for(int i = 0; i < 18; i++){
                int index = i % 6;
                int index1 =i % 3;
                String[] catNSubCat = catAndSubcategories[index].split("_");
                List<Product> productList = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(products,start,(start+range))));
                start += range+1;
                ProductCatalogue productCatalogue = new ProductCatalogue(i, catNSubCat[0], catNSubCat[index1], productList);
                productCatalogueRepository.save(productCatalogue);
            }

            for(int i =0; i < 10000; i++){

            }

        };
    }

    // Below MongoTemplate is created by using configuration xml...
//    @Bean
//    public MongoTemplate mongoTemplate(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        return context.getBean(MongoTemplate.class);
//    }

    //Below MongoDBTemplate is created using Java configuration, no use of config xml req in this case
    @Bean
    public MongoDbFactory mongoDbFactory(){
        //MongoClientURI uri = new MongoClientURI("mongodb://username:password@localhost/ecommercedb");
        return new SimpleMongoDbFactory(new MongoClient(),"ecommercedb");
    }

    @Bean
    public MongoTemplate mongoTemplate(){
            return new MongoTemplate(mongoDbFactory());
    }
}
