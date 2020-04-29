package fr.airels.lecompteestbon;

import java.util.ArrayList;
import java.util.List;

public class Resolver {

    public static List<String> resolve(int result, List<Integer> numbers) {
        List<String> steps = new ArrayList<>();

        int resultOperation = 0;

        for (int i = 0; resultOperation != result; i++) {
            List<Integer> numbersToUse = new ArrayList<>(numbers);
            resultOperation = 0;

            steps.add(i + " try");

            while (resultOperation != result && numbersToUse.size() > 1) {
                int[] indexNumbers = randomPick(numbersToUse);
                int a = numbersToUse.get(indexNumbers[0]);
                int b = numbersToUse.get(indexNumbers[1]);

                Operation.OperationResult c = Operation.randomCalc(a, b);
                resultOperation = c.result;

                steps.add(a + c.operandUsed + b + " = " + c.result);

                numbersToUse.remove(Integer.valueOf(a));
                numbersToUse.remove(Integer.valueOf(b));
                numbersToUse.add(resultOperation);
            }

            steps.add("");
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
