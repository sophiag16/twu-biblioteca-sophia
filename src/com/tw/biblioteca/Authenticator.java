//has a set of valid users and verifies if the library number and password given to it are valid
package com.tw.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> userArrayList = new ArrayList<User>();

    public Authenticator() {
        userArrayList.add(new User("111-1111", "abcxyz", "user", "Sophia", "sophia@gmail.com", "8764656", new Display(new PrintStream(System.out))));
        userArrayList.add(new User("222-2222", "123456", "user", "Keerthana", "keerthas@gmail.com", "457976986", new Display(new PrintStream(System.out))));
        userArrayList.add(new User("000-0000", "secret", "admin", "Jhalaa", "jhalach@gmail.com", "99965354", new Display(new PrintStream(System.out))));
    }

    public User isValid(String libraryNumber, String password) {
        User user = new User(libraryNumber, "", "", "", "", "", new Display(new PrintStream(System.out)));
        if(userArrayList.contains(user) && userArrayList.get(userArrayList.indexOf(user)).checkPassword(password)) {
            return userArrayList.get(userArrayList.indexOf(user));
        }
        return new User();
    }
}