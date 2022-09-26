package api.Controller;

import api.Entity.Brand;
import api.Entity.Car;
import api.Repository.BrandRepository;
import api.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BrandRepository brandRepository;

    @QueryMapping
    Iterable<Car> cars(){
        return carRepository.findAll();
    }


    @QueryMapping
    Iterable<Car> findCarByBrand(@Argument String brandName){
        return carRepository.findCarsByBrand_BrandName(brandName);
    }

    @MutationMapping
    Car addCar(@Argument CarInput carInput){
        Optional<Brand> brand = brandRepository.findById(carInput.brandID);
        Car car = new Car(carInput.title, carInput.price,carInput.age,brand.get());
        return carRepository.save(car);
    }

    record CarInput(String title,int price,int age,Long brandID){}

}
