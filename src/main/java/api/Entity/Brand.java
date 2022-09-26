package api.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String brandName;

    private String country;

    @OneToMany(fetch = FetchType.EAGER)
    List<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
