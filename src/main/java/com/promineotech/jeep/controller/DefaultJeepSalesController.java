package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;

//have to tell SpringBoot that this controller is a rest controller
//not done in interface done in class 
@RestController //tells SpringBoot that this class is special and a
//controller that implements jeep sales controller
public class DefaultJeepSalesController implements JeepSalesController {

  @Override
  public List<Jeep> fetchJeeps(String model, String trim) {
    // TODO Auto-generated method stub
    return null;
  }

}
