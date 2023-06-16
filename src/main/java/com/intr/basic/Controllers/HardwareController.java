package com.intr.basic.Controllers;

import com.intr.basic.Model.Hardware;
import com.intr.basic.Services.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;



    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hardware findById(@PathVariable(value = "id") String id) throws Exception{

        return  hardwareService.findById(id);

    }

    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hardware> findAll(){

        return  hardwareService.findAll();


    }

    @RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hardware create(@RequestBody Hardware person){

        return  hardwareService.create(person);

    }

    @RequestMapping(method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hardware update(@RequestBody Hardware person){

        return  hardwareService.update(person);

    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id){

        hardwareService.delete(id);

    }

}
