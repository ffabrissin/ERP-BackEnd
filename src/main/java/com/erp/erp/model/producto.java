package com.erp.erp.model;

import jakarta.persistence.*;
import java.util.Objects;

/**
 *
 * @author piti_
 */
@Entity
@Table(name = "products")
public class producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer strock;

    public producto() {
    }

    public producto(Long id, String name, Double price, Integer strock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.strock = strock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStrock() {
        return strock;
    }

    public void setStrock(Integer strock) {
        this.strock = strock;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final producto other = (producto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "producto{" + "id=" + id + '}';
    }

}
