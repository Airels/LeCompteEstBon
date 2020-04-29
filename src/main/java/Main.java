import fr.airels.lecompteestbon.Resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int result = 531;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(80, 2, 13, 11, 25, 3));

        List<String> operationsMade = Resolver.resolve(result, numbers);

        for (String operationMade : operationsMade) {
            System.out.println(operationMade);
        }
    }
}
