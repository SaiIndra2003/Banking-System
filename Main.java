import com.banking.bank.Bank;


public class Main {

    public static void main(String[] args){
        Bank bank = new Bank();
        bank.createSavingsAccount("2124",3);
        bank.createSavingsAccount("1145",5);
        bank.createCurrentAccount("2003",5);
        bank.deposit("2124",100.0);
        bank.deposit("2124",110.0);
        bank.deposit("2124",150.0);
        bank.deposit("1145",10.0);

        bank.withdraw("2003",2.0);
        bank.withdraw("2124",200.0);
        bank.withdraw("3002",200);
        bank.generateBalanceReport("1145");
        bank.generateTransactionHistoryReport("2124");
        bank.generateBalanceReport("2124");
    }
}
