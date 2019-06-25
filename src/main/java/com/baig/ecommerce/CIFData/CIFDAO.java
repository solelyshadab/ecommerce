package com.baig.ecommerce.CIFData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CIFDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertCIFData(){

        CIFData cifData = new CIFData(3,"PM3","Cust3","Q3");
        CIFData cifData1 = new CIFData(4,"PM4","Cust4","Q4");
        List<CIFData> list = new ArrayList<>();
        list.add(cifData); list.add(cifData1);
        //mongoTemplate.insert(cifData);

        //mongoTemplate.insert(list, "cIFData");
        //mongoTemplate.insert(list,CIFData.class);
        //save will look for id, if present will update, else will create new record
        mongoTemplate.save(cifData, "cIFData");
    }

    public CIFData getCIFDataById(int id){
        updateCustomFields(1,1,1,1);
        return mongoTemplate.findById(id,CIFData.class);

    }

    public void changePM(String newPMNName){

        // change records by the specified Update method
        Query query = query(where("projectManager").is("PM2"));
        Query query1 = query(where("projctManager").is("PM3").and(""));
        Update update = update("projectManager",newPMNName);
        mongoTemplate.upsert(query,update,CIFData.class);

        //Update all records based on argument provided in Update
        mongoTemplate.updateMulti(new Query(), update, CIFData.class);

      // Below is a simple update API, effective for simple cases

//        BasicQuery query = new BasicQuery("{projectManager:'PM1'}");
//        CIFData cifData = mongoTemplate.find(query, CIFData.class).get(0);
//        cifData.setProjectManager(newPMNName);
//        mongoTemplate.save(cifData);

    }

    public void updateCustomFields(Integer cifID, Integer coID, Integer soID, Integer soiID){
        Query query = query(where("id").is(cifID).and("cIFData.customerOrder.id").is(coID));
        CIFData cifData = mongoTemplate.findOne(query, CIFData.class);
    }
}
