package ai.hyacinth.core.service.examples.food.boot;

import ai.hyacinth.core.service.examples.food.config.FoodApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({FoodApplicationConfig.class})
@Slf4j
public class FoodApplication implements ApplicationListener<ApplicationReadyEvent> {
  public static void main(String[] args) {
    SpringApplication.run(FoodApplication.class, args);
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    String key = "spring.flyway.enabled";
    String value = event.getApplicationContext().getEnvironment().getProperty(key);
    log.info("property value: {} = {}", key, value);
  }
}
