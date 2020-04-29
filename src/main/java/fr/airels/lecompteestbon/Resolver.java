package fr.airels.lecompteestbon;

import java.util.ArrayList;
import java.util.List;

public class Resolver {

    public static List<String> resolve(int result, List<Integer> numbersToUse) {
        List<String> steps = new ArrayList<>();

        int resultOperation = 0;

        while (resultOperation != result) {
            int[] indexNumbers = randomPick(numbersToUse);
            int a = indexNumbers[0];
            int b = indexNumbers[1];

            Operation.OperationResult c = Operation.randomCalc(a, b);
            resultOperation = c.result;

            steps.add(a + c.operandUsed + b + " = " + c.result);
        }

        return steps;
    }

    private static int[] randomPick(List<Integer> numbersToUse) {
        int indexA = (int) (Math.random() * numbersToUse.size());
        int indexB;
        do {
            indexB = (int) (Math.random() * numbersToUse.size());
        } while (indexA == indexB);

        return new int[]{indexA, indexB};
    }
}
