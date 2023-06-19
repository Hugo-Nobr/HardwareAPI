package com.intr.basic.Services;

import com.intr.basic.Exceptions.ResourceNotFoundException;
import com.intr.basic.Model.Hardware;
import com.intr.basic.Repository.HardwareRepository;
import com.intr.basic.data.vo.v1.HardwareVO;
import com.intr.basic.mapper.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class HardwareService {

    private final Logger logger = Logger.getLogger(HardwareService.class.getName());

    @Autowired
    HardwareRepository repository;


    public List<HardwareVO> findAll(){

        logger.info("Finding all Hardwares!");

        return DozerMapper.parseList(repository.findAll(), HardwareVO.class);
    }


    public HardwareVO findById(Long id){

        logger.info("Finding one HardwareVO!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerMapper.parseObject(entity, HardwareVO.class);

    }

    public HardwareVO create(HardwareVO hardware) {

        logger.info("Creating one hardwares");
        var entity = DozerMapper.parseObject(hardware, Hardware.class);

        return DozerMapper.parseObject(repository.save(entity), HardwareVO.class);


    }

    public HardwareVO update(HardwareVO hardware) {

        logger.info("Updating one hardware");

        var entity = repository.findById(hardware.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setModel(hardware.getModel());
        entity.setCategory(hardware.getCategory());
        entity.setConfig(hardware.getConfig());
        entity.setPrice(hardware.getPrice());

        return DozerMapper.parseObject(repository.save(entity), HardwareVO.class);



    }

    public void delete(Long id) {

        logger.info("Deleting one hardware");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);

    }





}
