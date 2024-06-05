import inno.*;
import org.junit.jupiter.api.Test;

public class TestModule {
    @Test
    public void testAccountNotNull() {
        String name = "Эмма";
        try {
            Account tmpAccount = new Account(name);
            System.out.println("testAccountNotNull Account создан");

        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAccountNull() {
        String name = null;
        try {
            Account tmpAccount = new Account(name);

        } catch (NullPointerException e) {
            System.out.println("testAccountNull Исключение пустое имя");
        }
    }

    @Test
    public void testCurrencyCount() {
        String name = null;
        Currency tmpCurrency = new Currency(CodeCur.RUB,5);
        tmpCurrency.setCountCur(10);
        System.out.println("testCurrencyCount положительная сумма");
        try {
            tmpCurrency.setCountCur(-100);

        } catch (IllegalArgumentException e) {
            System.out.println("testCurrencyCount Исключение отрицательная сумма");
        }
    }

    @Test
    public void testUndo() {
        Account acc = new Account("Злата");
        Currency cur = new Currency(CodeCur.RUB,11);
        cur.setCodeCur(CodeCur.USD);
        cur.setCountCur(100);
        acc.setCurrency(cur);
        acc.setName("Петя");
        cur.setCodeCur(CodeCur.RUB);
        cur.setCountCur(300);
        acc.setCurrency(cur);
        acc.undo();
        acc.undo();
        System.out.println("testUndo успех");
    }

    @Test
    public void testCopyAndRestore() {
        Account acc = new Account("Катя");
        Currency cur = new Currency(CodeCur.RUB,0);
        SaveAccount accCopy = new SaveAccount();
        cur.setCodeCur(CodeCur.USD);
        cur.setCountCur(100);
        acc.setCurrency(cur);
        accCopy.copyAccount(acc);
        System.out.println("testCopy успех");
        acc.setName("Надя");
        accCopy.restoreAccount(acc);
        System.out.println("restoreAccount успех");
    }

}
