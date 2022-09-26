package api.Entity;

import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private int price;

    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    public Car(String title, int price, int age, Brand brand) {
        this.title = title;
        this.price = price;
        this.age = age;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
