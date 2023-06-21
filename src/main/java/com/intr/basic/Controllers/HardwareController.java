package com.intr.basic.Controllers;

import com.intr.basic.Services.HardwareService;
import com.intr.basic.Util.MediaType;
import com.intr.basic.data.vo.v1.HardwareVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;



    @GetMapping( value = "/{id}",
                produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YML})
    public HardwareVO findById(@PathVariable(value = "id") Long id){

        return  hardwareService.findById(id);

    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    public List<HardwareVO> findAll(){

        return  hardwareService.findAll();


    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public HardwareVO create(@RequestBody HardwareVO hardware){
        return  hardwareService.create(hardware);

    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public HardwareVO update(@RequestBody HardwareVO person){

        return  hardwareService.update(person);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){

        hardwareService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
