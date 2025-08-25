package ru.kata.spring.REST_JS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.kata.spring.REST_JS.service.RoleService;
import ru.kata.spring.REST_JS.service.UserService;
import ru.kata.spring.REST_JS.models.Role;
import ru.kata.spring.REST_JS.models.User;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
		try {
			UserService userService = context.getBean(UserService.class);
			RoleService roleService = context.getBean(RoleService.class);

			User user1 = new User("Admin", "Adminov", "admin", 22, "Admin@mail.ru");
			User user2 = new User("Pavel", "Pavlov", "pavel", 33, "Pavel@mail.ru");
			User user3 = new User("Ivan", "Ivanov", "ivan", 44, "Ivan@mail.ru");

			Role roleAdmin = new Role("ROLE_ADMIN");
			Role roleUser = new Role("ROLE_USER");

			Set<Role> rolesAdmin = new HashSet<>();
			rolesAdmin.add(roleAdmin);
			rolesAdmin.add(roleUser);

			Set<Role> rolesUsers = new HashSet<>();
			rolesUsers.add(roleUser);

			user1.setRoles(rolesAdmin);
			user2.setRoles(rolesUsers);
			user3.setRoles(rolesUsers);

			roleService.addRole(roleAdmin);
			roleService.addRole(roleUser);

			userService.saveUser(user1);
			userService.saveUser(user2);
			userService.saveUser(user3);

		} catch (Exception ignored) {
		}
	}
}
