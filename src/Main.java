import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int weight = 713;
        int attempt = 0;

        int[] cargoLocation = new int[3];
        int[] randomLocation = new int[3];

        for (int i = 0; i < randomLocation.length; i++) {
            randomLocation[i] = 1 + random.nextInt(7);
            System.out.print(randomLocation[i] + " ");
        }
        while (attempt < 5) {
            for (int i = 0; i < cargoLocation.length; i++) {
                System.out.println("Enter " + (i + 1) + "-location of box:");
                cargoLocation[i] = scanner.nextInt();
            }

            int correctMarks = 0;
            if (cargoLocation[0] == randomLocation[0]) {
                correctMarks++;
            }
            if (cargoLocation[1] == randomLocation[1]) {
                correctMarks++;
            }
            if (cargoLocation[2] == randomLocation[2]) {
                correctMarks++;
            }
            attempt++;

            if (correctMarks == 3) {
                System.out.println("Congratulations!🥳 🎉 You found all boxes.");
                int[] weights = weightOfCargo(weight);
                System.out.println("The weights of the boxes are: " + weights[0] + ", " + weights[1] + ", " + weights[2]);
                break;
            } else {
                System.out.println("Number of correct marks: " + correctMarks);

                if (attempt == 5) {
                    clean();
                    System.out.println("The boxes have changed their location because your attempts run out.Try yuor luck again.");
                    for (int i = 0; i < randomLocation.length; i++) {
                        randomLocation[i] = 1 + random.nextInt(7);
                        System.out.print(randomLocation[i] + " ");
                    }
                    attempt = 0;
                } else {
                    clean();
                    System.out.println("You have " + (5 - attempt) + " attempts left.");
                }
            }
        }
    }
    public static int[] weightOfCargo(int weight) {
        Random random = new Random();
        int sumOfWeight = 713;

        int box1 = random.nextInt(sumOfWeight + 1);
        int box2 = random.nextInt(sumOfWeight - box1 + 1);
        int box3 = sumOfWeight - box1 - box2;

        return new int[]{box1, box2, box3};
    }
    public static void clean()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}