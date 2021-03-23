/*2) BankAccount
https://gist.github.com/akadatsky/2f147f53781bedceb1850742a7d60b20 */
package bank;

public class Main {
        public static void main(String[] args) {
                BankAccount boss = new BankAccount("Oleg", 0);
                BankAccount ivan = new BankAccount("Ivan", 0);
                BankAccount alex = new BankAccount("Alex", 0);
                BankAccount sergey = new BankAccount("Sergey", 0);
                boss.add(100000);
                boss.transfer(ivan, 10000);
                boss.transfer(alex, 15000);
                boss.transfer(sergey, 20000);
                System.out.println("Boss: ,баланс "+ boss.getCount()+ ", Ivan: "+ ivan.getCount() +
                        ", Alex: "+ alex.getCount()+", Sergey: "+ sergey.getCount());
                System.out.println("Прибыль банка: "+BankAccount.profitBank);
            }
        }
