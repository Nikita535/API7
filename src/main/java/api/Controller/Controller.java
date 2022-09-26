package api.Controller;

import api.Entity.Car;
import api.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    CarRepository carRepository;

    @QueryMapping
    Iterable<Car> cars(){
        return carRepository.findAll();
    }


}
