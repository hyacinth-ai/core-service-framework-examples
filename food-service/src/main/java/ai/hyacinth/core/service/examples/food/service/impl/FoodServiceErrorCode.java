package ai.hyacinth.core.service.examples.food.service.impl;

import ai.hyacinth.core.service.web.common.ServiceApiErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FoodServiceErrorCode implements ServiceApiErrorCode {
  NOT_SUCH_DISH(HttpStatus.NOT_FOUND, "100000"),
  POINTS_RANGE_ERROR(HttpStatus.BAD_REQUEST, "100002");

  private HttpStatus httpStatus;
  private String code;

  @Override
  public int getHttpStatusCode() {
    return httpStatus.value();
  }

  @Override
  public String getCode() {
    return code;
  }
}
