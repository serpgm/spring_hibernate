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

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.add(new User("Ivan", "Pushkin", "iv@mail.ru", new Car("BMV", 228)));
      userService.add(new User("Petr", "Sidorov", "p@mail.ru", new Car("audi", 2000)));
      userService.add(new User("Vasya", "Ivanov", "v@mail.ru", new Car("niva", 2121)));
      userService.add(new User("Nina", "Zubkova", "nina@mail.ru", new Car("lada", 2010)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
     System.out.println(userService.getUserByCar("niva", 2121));
      context.close();
   }
}
