import inno.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Account account = new Account("Эмма");
        Currency cur = new Currency(CodeCur.USD,5);
        account.setCurrency(cur);

    }
}
