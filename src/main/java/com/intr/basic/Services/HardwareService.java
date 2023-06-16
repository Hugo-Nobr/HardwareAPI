package com.intr.basic.Services;

import com.intr.basic.Model.Hardware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class HardwareService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(HardwareService.class.getName());

    public List<Hardware> findAll(){

        List<Hardware> hardwares = new ArrayList<>();

        logger.info("Finding all Hardwares!");
        for(int i = 0; i < 8; i++){
            Hardware hardware = mockPerson(i);
            hardwares.add(hardware);
        }

        return hardwares;
    }


    public Hardware findById(String id){

        logger.info("Finding one Hardware!");
        Hardware hardware = new Hardware();

        Long id_long = Long.parseLong(id);
        hardware.setId(id_long);
        hardware.setModel("Gamer");
        hardware.setConfig("Ryzen 5 5600x");
        hardware.setCategory("CPU");
        hardware.setPrice(2500.0);


        return hardware;
    }

    public Hardware create(Hardware hardwares) {

        logger.info("Creating one hardwares");

        return hardwares;


    }

    public Hardware update(Hardware hardware) {

        logger.info("Updating one hardware");

        return hardware;

    }

    public void delete(String id) {

        logger.info("Deleting one hardware");


    }



    private Hardware mockPerson(int i) {

        Hardware hardware = new Hardware();
        hardware.setId(counter.incrementAndGet());
        hardware.setModel("Gamer");
        hardware.setConfig("Ryzen 5 5600x");
        hardware.setCategory("CPU");
        hardware.setPrice(2500.0);



        return hardware;


    }


}
