package com.intr.basic.Services;

import com.intr.basic.Controllers.HardwareController;
import com.intr.basic.Exceptions.ResourceNotFoundException;
import com.intr.basic.Model.Hardware;
import com.intr.basic.Repository.HardwareRepository;
import com.intr.basic.data.vo.v1.HardwareVO;
import com.intr.basic.mapper.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class HardwareService {

    private final Logger logger = Logger.getLogger(HardwareService.class.getName());

    @Autowired
    HardwareRepository repository;


    public List<HardwareVO> findAll(){

        logger.info("Finding all Hardwares!");

        var hardware =  DozerMapper.parseList(repository.findAll(), HardwareVO.class);
        hardware.stream().forEach(p -> {
            try {
                p.add(linkTo(methodOn(HardwareController.class).findById(p.getKey())).withSelfRel());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return hardware;

    }


    public HardwareVO findById(Long id){

        logger.info("Finding one HardwareVO!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        HardwareVO vo = DozerMapper.parseObject(entity, HardwareVO.class);
        vo.add(linkTo(methodOn(HardwareController.class).findById(id)).withSelfRel());
        return vo;


    }

    public HardwareVO create(HardwareVO hardware){

        logger.info("Creating one hardwares");
        var entity = DozerMapper.parseObject(hardware, Hardware.class);

        var vo = DozerMapper.parseObject(entity, HardwareVO.class);
        vo.add(linkTo(methodOn(HardwareController.class).findById(vo.getKey())).withSelfRel());

        return vo;

    }

    public HardwareVO update(HardwareVO hardware){

        logger.info("Updating one hardware");

        var entity = repository.findById(hardware.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setModel(hardware.getModel());
        entity.setCategory(hardware.getCategory());
        entity.setConfig(hardware.getConfig());
        entity.setPrice(hardware.getPrice());

        HardwareVO vo = DozerMapper.parseObject(entity, HardwareVO.class);
        vo.add(linkTo(methodOn(HardwareController.class).findById(vo.getKey())).withSelfRel());
        return vo;



    }

    public void delete(Long id) {

        logger.info("Deleting one hardware");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);

    }





}
