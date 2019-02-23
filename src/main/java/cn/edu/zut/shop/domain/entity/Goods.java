package cn.edu.zut.shop.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author liuhao on 2019/2/22 0022
 * @description 商品表信息
 */
@Table(name = "products")
@Entity
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private Integer price;

    @Column(unique = true)
    private String image;

    @Column()
    private String classification;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Goods(String name, Integer count, Integer price, String image, String classification) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.image = image;
        this.classification = classification;
    }

    public Goods() {
    }
}
