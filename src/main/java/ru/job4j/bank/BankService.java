package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 */
public class BankService {
    /**
     * Поле {@code passport} содержит клиентов банка со списком счетов для каждого клиента
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в систему, если такой клиент не был добавлен ранее
     * @param user - добавляемый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет банковский счет в список счетов клиента. Если клиент в системе
     * не найден добавление не происходит
     * @param passport - паспортные данные клиента, чей счет будет добавлен
     * @param account - добавляемый банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
           List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит клиента по паспортным данным
     * @param passport - паспортные данные искомого клиента
     * @return - искомый клиент или {@code null} если клиент не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит банковский счет клиента по номеру счета
     * @param passport - паспортные данные клиента - владельца счета
     * @param requisite - номер искомого счета
     * @return - искомый банковский счет или {@code null} если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет перевести денежные средства между счетами клиентов. Если один из счетов
     * не найден или средств на счете для списания недостаточно операция не производится
     * @param srcPassport - паспортные данные клиента - владельца счета для списания
     * @param srcRequisite - номер счета для списания
     * @param destPassport - паспортные данные клиента - владельца счета для зачисления
     * @param destRequisite - номер счета для зачисления
     * @param amount - сумма средств для списания/зачисления
     * @return - логический признак успешности операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }
}
