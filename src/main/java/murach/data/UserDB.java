// src/main/java/murach/data/UserDB.java
package murach.data;

import murach.business.User;

public class UserDB {
    public static void insert(User user) {
        System.out.println("Inserted user: "
            + user.getEmail() + ", "
            + user.getFirstName() + " "
            + user.getLastName());
    }
}
