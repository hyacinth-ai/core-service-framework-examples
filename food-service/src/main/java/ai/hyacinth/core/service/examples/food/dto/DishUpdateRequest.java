package ai.hyacinth.core.service.examples.food.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DishUpdateRequest {
  private Integer point;
  private String ingredient;
}
