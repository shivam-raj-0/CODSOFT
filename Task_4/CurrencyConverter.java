package Task_4;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double rate = 0;
        double amount, result;

        System.out.println("===== Currency Converter =====");

        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.println("3. EUR to INR");
        System.out.println("4. INR to EUR");

        System.out.print("Select Conversion Option: ");
        int choice = sc.nextInt();

        System.out.print("Enter Amount: ");
        amount = sc.nextDouble();

        switch(choice)
        {
            case 1:
                rate = 83.0;
                result = amount * rate;
                System.out.println("Converted Amount: ₹ " + result);
                break;

            case 2:
                rate = 0.012;
                result = amount * rate;
                System.out.println("Converted Amount: $ " + result);
                break;

            case 3:
                rate = 90.0;
                result = amount * rate;
                System.out.println("Converted Amount: ₹ " + result);
                break;

            case 4:
                rate = 0.011;
                result = amount * rate;
                System.out.println("Converted Amount: € " + result);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
