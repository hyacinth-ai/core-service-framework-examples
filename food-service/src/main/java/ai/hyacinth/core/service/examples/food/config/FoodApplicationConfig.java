package ai.hyacinth.core.service.examples.food.config;

import ai.hyacinth.core.service.endpoint.support.config.EndpointConfig;
import ai.hyacinth.core.service.examples.food.domain.Dish;
import ai.hyacinth.core.service.examples.food.repo.DishRepo;
import ai.hyacinth.core.service.examples.food.service.FoodService;
import ai.hyacinth.core.service.examples.food.web.DishController;
import ai.hyacinth.core.service.jpa.config.JpaConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackageClasses = {Dish.class}) // domain-class
@EnableJpaRepositories(basePackageClasses = {DishRepo.class}) // repo
@ComponentScan(
    basePackageClasses = {FoodService.class, DishController.class}) // service and controller
@Import({EndpointConfig.class, JpaConfig.class}) // support modules
public class FoodApplicationConfig {}
