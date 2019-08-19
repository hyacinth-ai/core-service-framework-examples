package ai.hyacinth.core.service.examples.food.web;

import ai.hyacinth.core.service.examples.food.dto.DishInfo;
import ai.hyacinth.core.service.examples.food.dto.NewDishRequest;
import ai.hyacinth.core.service.examples.food.dto.DishUpdateRequest;
import ai.hyacinth.core.service.examples.food.service.FoodService;
import ai.hyacinth.core.service.web.common.ServiceApiConstants;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ServiceApiConstants.API_PREFIX)
public class DishController {

  @Autowired private FoodService foodService;

  @PatchMapping("/dish/{dishId}")
  public DishInfo updateDish(
      @PathVariable("dishId") Long dishId,
      @Validated @RequestBody DishUpdateRequest dishUpdateRequest) {
    return foodService.updateDish(dishId, dishUpdateRequest);
  }

  @GetMapping("/dish")
  public List<DishInfo> findAllDish() {
    return foodService.findAllDish();
  }

  @PostMapping("/dish")
  public DishInfo addNewDish(@RequestBody @Valid NewDishRequest newDishRequest) {
    return foodService.addDish(newDishRequest);
  }
}
