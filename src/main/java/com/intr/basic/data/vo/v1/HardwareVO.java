package com.intr.basic.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;


public class HardwareVO implements Serializable {


    private Long id;
    private static final long serialVersionUID = 1L;


    public HardwareVO(){
    }

    private String category;
    private String model;
    private String config;


    private Double price;
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HardwareVO hardware = (HardwareVO) o;
        return Objects.equals(id, hardware.id) && Objects.equals(model, hardware.model) && Objects.equals(price, hardware.price) && Objects.equals(config, hardware.config) && Objects.equals(category, hardware.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, price, config, category);
    }


}
