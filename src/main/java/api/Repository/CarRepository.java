package api.Repository;

import api.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findCarsByBrand_BrandName(String brandName);
}
