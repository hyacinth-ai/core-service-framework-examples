package ai.hyacinth.core.service.examples.food.service.impl;

import ai.hyacinth.core.service.examples.food.domain.Dish;
import ai.hyacinth.core.service.examples.food.dto.DishInfo;
import ai.hyacinth.core.service.examples.food.dto.NewDishRequest;
import ai.hyacinth.core.service.examples.food.dto.DishUpdateRequest;
import ai.hyacinth.core.service.examples.food.repo.DishRepo;
import ai.hyacinth.core.service.examples.food.service.FoodService;
import ai.hyacinth.core.service.web.common.ServiceApiException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class FoodServiceImpl implements FoodService {

  @Autowired private DishRepo dishRepo;

  @Override
  @Transactional
  public DishInfo updateDish(Long dishId, DishUpdateRequest request) {
    if (request.getPoint() != null && !(request.getPoint() >= 0 && request.getPoint() <= 3)) {
      throw new ServiceApiException(FoodServiceErrorCode.POINTS_RANGE_ERROR);
    }

    return dishRepo
        .findById(dishId)
        .map(
            (dish) -> {
              if (request.getPoint() != null) {
                dish.setPoint(request.getPoint());
              }
              if (request.getIngredient() != null) {
                dish.setIngredient(request.getIngredient());
              }
              return toDishInfo(dish);
            })
        .orElseThrow(() -> new ServiceApiException(FoodServiceErrorCode.NOT_SUCH_DISH));
  }

  @Override
  @Transactional(readOnly = true)
  public List<DishInfo> findAllDish() {
    return dishRepo.findAll().stream().map(this::toDishInfo).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public DishInfo addDish(NewDishRequest newDishRequest) {
    Dish dish = new Dish();
    dish.setTitle(newDishRequest.getTitle());
    dish.setPoint(nullDefault(newDishRequest.getPoint(), 0));
    dish.setCategory(null);
    dish.setIngredient(nullDefault(newDishRequest.getIngredient(), ""));
    dishRepo.save(dish);
    return toDishInfo(dish);
  }

  private <T> T nullDefault(T input, T defaultValue) {
    return input == null ? defaultValue : input;
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
