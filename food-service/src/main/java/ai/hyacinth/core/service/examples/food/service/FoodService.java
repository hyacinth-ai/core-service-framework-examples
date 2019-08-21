package ai.hyacinth.core.service.examples.food.service;

import ai.hyacinth.core.service.examples.food.dto.DishInfo;
import ai.hyacinth.core.service.examples.food.dto.DishUpdateRequest;
import ai.hyacinth.core.service.examples.food.dto.NewDishRequest;
import java.util.List;

public interface FoodService {
  DishInfo updateDish(Long dishId, DishUpdateRequest request);

  List<DishInfo> findAllDish();

  DishInfo addDish(NewDishRequest newDishRequest);
}
