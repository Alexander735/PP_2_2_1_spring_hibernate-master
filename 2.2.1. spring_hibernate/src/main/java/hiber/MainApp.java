package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Ivan","Ivanov","ivanov@mail.ru");
      User user2 = new User("Peter","Petrov","petrov@mail.ru");

      user1.setCar(new Car("Porshe",911,user1));
      user2.setCar(new Car("BMW",7,user2));

      userService.add(user1);
      userService.add(user2);

      context.close();
   }
}
