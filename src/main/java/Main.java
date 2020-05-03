import fr.airels.lecompteestbon.Resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner reader = new Scanner(System.in);

        System.out.println("Result to find ?");
        int result = Integer.parseInt(reader.nextLine());

        // To respect TV show: 6 numbers, 9 first numbers, + 10, 25, 50, 75 and 100
        System.out.println("\nWhat numbers to use to resolve result ? (spaced with space)");
        String numbersEntered = reader.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersEntered.split(" "))
            numbers.add(Integer.parseInt(number));

        List<String> operationsMade = Resolver.naiveResolve(result, numbers);

        for (String operationMade : operationsMade) {
            System.out.println(operationMade);
        }

         */

        int result = 663;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(50, 25, 3, 9, 4, 1));

        Resolver.recursiveResolve(result, numbers);
    }
}
