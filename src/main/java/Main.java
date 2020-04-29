import fr.airels.lecompteestbon.Resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Result to find ?");
        int result = Integer.parseInt(reader.nextLine());

        System.out.println("\nWhat numbers to use to resolve result ? (spaced with space, 6 numbers to respect TV show rules)");
        String numbersEntered = reader.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersEntered.split(" "))
            numbers.add(Integer.parseInt(number));

        List<String> operationsMade = Resolver.resolve(result, numbers);

        for (String operationMade : operationsMade) {
            System.out.println(operationMade);
        }
    }
}
