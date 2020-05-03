import fr.airels.lecompteestbon.Resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
