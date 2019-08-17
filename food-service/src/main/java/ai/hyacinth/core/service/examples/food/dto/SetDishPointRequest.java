package ai.hyacinth.core.service.examples.food.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SetDishPointRequest {
  @NotNull private Integer point;
}
