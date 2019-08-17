package ai.hyacinth.core.service.examples.food.service;

import ai.hyacinth.core.service.examples.food.dto.DishInfo;
import ai.hyacinth.core.service.examples.food.dto.NewDishRequest;
import ai.hyacinth.core.service.examples.food.dto.SetDishPointRequest;
import java.util.List;

public interface FoodService {
  DishInfo setDishPoint(Long dishId, SetDishPointRequest request);

  List<DishInfo> findAllDish();

  DishInfo addDish(NewDishRequest newDishRequest);
}
