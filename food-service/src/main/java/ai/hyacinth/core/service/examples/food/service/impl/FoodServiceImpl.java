package ai.hyacinth.core.service.examples.food.service.impl;

import ai.hyacinth.core.service.examples.food.domain.Dish;
import ai.hyacinth.core.service.examples.food.dto.DishInfo;
import ai.hyacinth.core.service.examples.food.dto.NewDishRequest;
import ai.hyacinth.core.service.examples.food.dto.SetDishPointRequest;
import ai.hyacinth.core.service.examples.food.repo.DishRepo;
import ai.hyacinth.core.service.examples.food.service.FoodService;
import ai.hyacinth.core.service.web.common.ServiceApiException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
  @Autowired private DishRepo dishRepo;

  @Override
  public DishInfo setDishPoint(Long dishId, SetDishPointRequest request) {
    if (!(request.getPoint() != null && request.getPoint() >= 0 && request.getPoint() <= 3)) {
      throw new ServiceApiException(FoodServiceErrorCode.POINTS_RANGE_ERROR);
    }
    return dishRepo
        .findById(dishId)
        .map(
            (dish) -> {
              dish.setPoint(request.getPoint());
              return toDishInfo(dish);
            })
        .orElseThrow(() -> new ServiceApiException(FoodServiceErrorCode.NOT_SUCH_DISH));
  }

  @Override
  public List<DishInfo> findAllDish() {
    return dishRepo.findAll().stream().map(this::toDishInfo).collect(Collectors.toList());
  }

  @Override
  public DishInfo addDish(NewDishRequest newDishRequest) {
    Dish dish = new Dish();
    dish.setTitle(newDishRequest.getTitle());
    dish.setPoint(newDishRequest.getPoint() == null ? 0 : newDishRequest.getPoint());
    dish.setCategory(null);
    dish.setIngredient("");
    dishRepo.save(dish);
    return toDishInfo(dish);
  }

  private DishInfo toDishInfo(Dish dish) {
    DishInfo info = new DishInfo();
    info.setId(dish.getId());
    info.setCategory(dish.getCategory());
    info.setTitle(dish.getTitle());
    info.setPoint(dish.getPoint());
    info.setIngredient(dish.getIngredient());
    return info;
  }
}
