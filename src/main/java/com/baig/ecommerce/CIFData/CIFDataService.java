package com.baig.ecommerce.CIFData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CIFDataService {

    @Autowired
    private CIFDataRepository CIFDataRepository;

    @Autowired
    private CIFDAO cifdao;

    public CIFData getCIFDataById(Integer id) {

        return CIFDataRepository.findById(id).get();
    }

    public void setCIFData(CIFData CIFData){
        CIFDataRepository.save(CIFData);
    }

    public void setTempCIFData(){
        cifdao.insertCIFData();
    }

    public CIFData getCIFDataById(int id){
        return cifdao.getCIFDataById(id);
    }

    public void changePMName(String newName){
        cifdao.changePM(newName);
    }
}
