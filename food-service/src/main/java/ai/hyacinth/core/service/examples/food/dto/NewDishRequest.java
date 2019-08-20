package ai.hyacinth.core.service.examples.food.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewDishRequest {
  @NotNull private String title;

  @Min(0)
  @Max((3))
  private Integer point;

  private String ingredient;
}
