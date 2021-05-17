package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
           List<Account> list = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит банковский счет клиента по номеру счета
     * @param passport - паспортные данные клиента - владельца счета
     * @param requisite - номер искомого счета
     * @return - искомый банковский счет или {@code null} если счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }
}
