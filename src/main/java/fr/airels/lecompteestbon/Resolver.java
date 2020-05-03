package fr.airels.lecompteestbon;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resolver {

    public static List<String> naiveResolve(int result, List<Integer> numbers) {
        List<String> steps = new ArrayList<>();

        int resultOperation = 0;

        for (int i = 0; resultOperation != result; i++) {
            List<Integer> numbersToUse = new ArrayList<>(numbers);
            resultOperation = 0;

            steps.add("Try n" + i);

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


    public static List<String> recursiveResolve(int result, List<Integer> numbers) {
        List<String> steps = new ArrayList<>();
        if (!auxRecursiveResolve(result, numbers, steps)) steps.add("No result found");
        Collections.reverse(steps);
        return steps;
    }

    private static boolean auxRecursiveResolve(int result, List<Integer> numbers, List<String> steps) {
        if (numbers.size() == 1) return false;

        List<Integer> initialNumbers = new ArrayList<>(numbers);

        for (int i = 0; i < numbers.size()-1; i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                List<Integer> copiedNumbers;
                Couple couple = new Couple(numbers.get(i), numbers.get(j));

                numbers.remove(i);
                numbers.remove(j-1);

                // Addition
                copiedNumbers = new ArrayList<>(numbers);
                if (couple.getAddition() == result) {
                    addStep(steps, couple, 0);
                    return true;
                }
                copiedNumbers.add(couple.getAddition());
                if (auxRecursiveResolve(result, copiedNumbers, steps)) {
                    addStep(steps, couple, 0);
                    return true;
                }

                // Substraction
                copiedNumbers = new ArrayList<>(numbers);
                if (couple.getSubstraction() == result) {
                    addStep(steps, couple, 1);
                    return true;
                }
                if (couple.getSubstraction() != 0) {
                    copiedNumbers.add(couple.getSubstraction());
                    if (auxRecursiveResolve(result, copiedNumbers, steps)) {
                        addStep(steps, couple, 1);
                        return true;
                    }
                }

                // Multiplication
                copiedNumbers = new ArrayList<>(numbers);
                if (couple.getMultiplication() == result) {
                    addStep(steps, couple, 2);
                    return true;
                }
                copiedNumbers.add(couple.getMultiplication());
                if (auxRecursiveResolve(result, copiedNumbers, steps)) {
                    addStep(steps, couple, 2);
                    return true;
                }

                // Division
                if (couple.isDivisible()) {
                    copiedNumbers = new ArrayList<>(numbers);
                    if (couple.getDivision() == result) {
                        addStep(steps, couple, 3);
                        return true;
                    }
                    copiedNumbers.add(couple.getDivision());
                    if (auxRecursiveResolve(result, copiedNumbers, steps)) {
                        addStep(steps, couple, 3);
                        return true;
                    }
                }

                numbers = initialNumbers;
            }
        }

        return false;
    }

    /*
        0 = +,
        1 = -,
        2 = *,
        3 = /
     */
    private static void addStep(List<String> steps, Couple couple, int operation) {
        switch (operation) {
            case 0:
                steps.add(couple.getNumber1() + " + " + couple.getNumber2() + " = " + couple.getAddition());
                break;
            case 1:
                if (couple.getNumber1() > couple.getNumber2())
                    steps.add(couple.getNumber1() + " - " + couple.getNumber2() + " = " + couple.getSubstraction());

                steps.add(couple.getNumber2() + " - " + couple.getNumber1() + " = " + couple.getSubstraction());
                break;
            case 2:
                steps.add(couple.getNumber1() + " x " + couple.getNumber2() + " = " + couple.getMultiplication());
                break;
            case 3:
                if (couple.getNumber1() > couple.getNumber2())
                    steps.add(couple.getNumber1() + " / " + couple.getNumber2() + " = " + couple.getDivision());

                steps.add(couple.getNumber2() + " / " + couple.getNumber1() + " = " + couple.getDivision());
                break;
            default:
                throw new RuntimeException("Unknown operation " + operation);
        }
    }
}
