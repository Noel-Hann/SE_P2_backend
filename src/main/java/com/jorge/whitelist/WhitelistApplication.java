package com.jorge.whitelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;



import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class WhitelistApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhitelistApplication.class, args);
	}

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
    String home() {
      return "Hello World!";
    }

	// TODO: remove this, just here for short testing purposes for team members
	 @RequestMapping("/dbtest")
    public String dbTest() {
        try {
			// Query to get all users
            List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM Users");

            // Build a string to display the query results
            StringBuilder result = new StringBuilder("The DB is working! Users:\n");

            for (Map<String, Object> row : users) {
                // Assuming the table has 'id', 'username', and 'password' columns
                result.append("ID: ").append(row.get("id"))
                      .append(", Username: ").append(row.get("username"))
                      .append(", Password: ").append(row.get("password"))
                      .append("\n");
            }

            if (users.isEmpty()) {
                result.append("No users found.");
            }

            return result.toString();
        } catch (Exception e) {
            return "The DB is NOT working: " + e.getMessage();
        }
    }


            //the return type is the number of rows that have been changed.
            //This should usually be 1. If it is 0, that means that no user has
            //been added, like if you tried to add a user who already exists.
            //if it is a negative number, it is an error.
            //if it is greater than 1, something is wrong with the database
    @PostMapping("/addUser")
    public int addUser(@RequestBody User user) {

        try{
             String query = "Insert into users (username, password) Values = ?,?)";

             int rowsChanged = jdbcTemplate.update(query, user.username, user.password);


             return rowsChanged;



        } catch (Exception e) {
            return -1;//an error code to show something didn't work
        }

    }


}
