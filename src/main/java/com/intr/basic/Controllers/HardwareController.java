package com.intr.basic.Controllers;

import com.intr.basic.Services.HardwareService;
import com.intr.basic.data.vo.v1.HardwareVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;



    @GetMapping( value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public HardwareVO findById(@PathVariable(value = "id") Long id) throws Exception{

        return  hardwareService.findById(id);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HardwareVO> findAll(){

        return  hardwareService.findAll();


    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HardwareVO create(@RequestBody HardwareVO hardware){
        return  hardwareService.create(hardware);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HardwareVO update(@RequestBody HardwareVO person){

        return  hardwareService.update(person);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){

        hardwareService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
