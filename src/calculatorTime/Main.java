/*1) TimeSpan
https://gist.github.com/akadatsky/92713505c20c4f3afa15abc65273c880 */

package calculatorTime;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во часов первого диапазона");
        int hours1 = scanner.nextInt();
        System.out.println("Введите кол-во минут первого диапазона");
        int minutes1 = scanner.nextInt();
        System.out.println("Введите кол-во часов второго диапазона");
        int hours2 = scanner.nextInt();
        System.out.println("Введите кол-во минут второго диапазона");
        int minutes2 = scanner.nextInt();
        System.out.println("Введите мультиплицирующий коеффициент");
        double koeficient = scanner.nextDouble();
        try {
            TimeSpan timeSpan1 = new TimeSpan(hours1, minutes1);
            TimeSpan timeSpan2 = new TimeSpan(hours2, minutes2);
            timeSpan1.add(timeSpan2);
            timeSpan1.sub(timeSpan2);
            timeSpan1.mult(koeficient);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
