package com.baig.ecommerce.CIFData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CIFDataController {

    @Autowired
    private CIFDataService CIFDataService;

    @CrossOrigin
    @RequestMapping("/cifData/get/{id}")
    public CIFData getCIFData(@PathVariable Integer id){
        return CIFDataService.getCIFDataById(id);

    }

    @CrossOrigin
    @RequestMapping("/cifData/setPMName/{name}")
    public String setnewPMName(@PathVariable String name){
        CIFDataService.changePMName(name);
        return "PM Name changed successfully";
    }

    @CrossOrigin
    @RequestMapping("/cifData/{id}/cifData")
    public void setCIFData(@PathVariable Integer id, @RequestBody CIFData CIFData){
        CIFDataService.setCIFData(CIFData);
    }

    @CrossOrigin
    @RequestMapping("/cifData")
    public String setTempCIFData(){
        CIFDataService.setTempCIFData();
        return "Temp CIF Data Inserted Successfully!!!";
    }

}
