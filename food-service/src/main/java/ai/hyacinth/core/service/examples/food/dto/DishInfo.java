package ai.hyacinth.core.service.examples.food.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DishInfo {
  private Long id;
  private String title;
  private String ingredient;
  private Integer point;
  private String category;
}
