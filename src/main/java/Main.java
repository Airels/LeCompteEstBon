import fr.airels.lecompteestbon.Resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int result = 732;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 25, 4, 10, 7, 6));

        List<String> operationsMade = Resolver.resolve(result, numbers);

        for (String operationMade : operationsMade) {
            System.out.println(operationMade);
        }
    }
}
