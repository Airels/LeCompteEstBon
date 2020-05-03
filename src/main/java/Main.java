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
        int result = 663;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(50, 25, 3, 9, 4, 1));

        List<String> operationsMade = Resolver.naiveResolve(result, numbers);
        for (String operationMade : operationsMade) {
            System.out.println(operationMade);
        }

        List<String> operationsMade2 = Resolver.recursiveResolve(result, numbers);
        for (String operationMade : operationsMade2) {
            System.out.println(operationMade);
        }
    }
}
