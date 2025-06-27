package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                 return users[i];
            }
        } throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException();

        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("Ошибка: пользователь невалиден");
        } catch (UserNotFoundException e) {
            System.out.println("Ошибка: пользователь не найден");
        }
    }
}