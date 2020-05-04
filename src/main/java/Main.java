import fr.airels.lecompteestbon.Resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
            If you want to respect TV Show Rules:
                - You must enter a result between 0-999
                - Only 6 numbers to use, which includes :
                    - 0-9 numbers, + 10, 25, 50, 75, 100 only
         */
        int result = 678;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(50, 25, 1, 6, 7, 9));

        // List<String> operationsMade = Resolver.naiveResolve(result, numbers);
        List<String> operationsMade = Resolver.recursiveResolve(result, numbers);
        for (String operationMade : operationsMade) {
            System.out.println(operationMade);
        }
    }
}
