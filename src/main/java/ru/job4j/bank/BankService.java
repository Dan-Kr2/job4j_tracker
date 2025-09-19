package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User x = findByPassport(passport);
        if (x != null) {
            users.remove(x);
        }
    }

    public void addAccount(String passport, Account account) {
        User x = findByPassport(passport);
        if (x != null) {
            List<Account> userAccounts = users.get(x);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User myUser : users.keySet()) {
            if (myUser.getPassport().equals(passport)) {
                return myUser;
            }
        } return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List <Account> userAccounts = users.get(user);
            for (Account myAccount : userAccounts) {
                if (myAccount.getRequisite().equals(requisite)) {
                    return myAccount;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account x = findByRequisite(sourcePassport, sourceRequisite);
        Account y = findByRequisite(destinationPassport, destinationRequisite);
        if ( x != null && y != null && x.getBalance() >= amount) {
            y.setBalance(y.getBalance() + amount);
            x.setBalance(x.getBalance() - amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}