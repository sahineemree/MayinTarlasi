import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Harita boyutunu giriniz : ");
        int boyut = input.nextInt();

        mineSweeper mine = new mineSweeper(boyut,boyut);
        mine.run();
    }
}