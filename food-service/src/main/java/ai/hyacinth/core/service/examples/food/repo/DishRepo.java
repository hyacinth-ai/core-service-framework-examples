package ai.hyacinth.core.service.examples.food.repo;

import ai.hyacinth.core.service.examples.food.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepo extends JpaRepository<Dish, Long> {}
