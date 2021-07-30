package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CarController {
    public List<Car> makeFiveCar() {
        Car car1 = new Car("Blue", "Mercedes", 1);
        Car car2 = new Car("Red", "BMW", 2);
        Car car3 = new Car("Green", "Audi", 3);
        Car car4 = new Car("White", "Ferrari", 4);
        Car car5 = new Car("Black", "Mazda", 5);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        return carList;
    }
    @GetMapping("/cars")
    public String showCarList (@RequestParam(value = "count", required = false) Integer count, Model model) {
//        if (count == null || count >= 5) {
//            model.addAttribute("message",makeFiveCar());
//        } else if (count == 2) {
//            model.addAttribute("message", makeFiveCar().get(0) + "\n" + makeFiveCar().get(1));
//        } else if (count == 3) {
//            model.addAttribute("message",
//                    makeFiveCar().get(0) +
//                            "\n" +
//                            makeFiveCar().get(1) +
//                            "\n" +
//                            makeFiveCar().get(2) );
//
//        } else if (count == 4) {
//            model.addAttribute("message",
//                    makeFiveCar().get(0) +
//                            "\n" +
//                            makeFiveCar().get(1) +
//                            "\n" +
//                            makeFiveCar().get(2) +
//                    "\n" +
//                            makeFiveCar().get(3) );
//        }
        if (count == null || count == 5) {
            model.addAttribute("cars", makeFiveCar());
        } else if (count == 4) {
            model.addAttribute("cars", makeFiveCar());

            return "car/car4";
        }
        return "car/cars";
    }
}
