package com.intr.basic.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;


@JsonPropertyOrder({"id", "category", "model", "config", "price"})
public class HardwareVO extends RepresentationModel<HardwareVO> implements Serializable {



    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String category;
    private String model;
    private Double price;
    private String config;

    private static final long serialVersionUID = 1L;

    public HardwareVO(){
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HardwareVO that = (HardwareVO) o;
        return Objects.equals(category, that.category) && Objects.equals(model, that.model) && Objects.equals(price, that.price) && Objects.equals(config, that.config) && Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, model, price, config, key);
    }

}
