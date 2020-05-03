package fr.airels.lecompteestbon;

import fr.airels.lecompteestbon.exceptions.NonIntegerValueException;
import fr.airels.lecompteestbon.exceptions.NonPositiveValueException;

public class Plate {
    private int number1, number2;

    public Plate(int n1, int n2) {
        number1 = n1;
        number2 = n2;
    }

    public int getAddition() {
        return number1+number2;
    }

    public int getSubstraction() throws NonPositiveValueException {
        int result = number1 - number2;

        if (result > 0) return number1-number2;

        throw new NonPositiveValueException("Difference of operation isn't a positive value");
    }

    public int getReverseSubstraction() throws NonPositiveValueException {
        int result = number2 - number1;

        if (result > 0) return number2-number1;

        throw new NonPositiveValueException("Difference of operation isn't a positive value");
    }

    public int getMultiplication() {
        return number1*number2;
    }

    public int getDivision() throws NonIntegerValueException {
        if (number1 % number2 == 0) return number1/number2;

        throw new NonIntegerValueException("Quotient of operation isn't an Integer");
    }

    public int getReverseDivision() throws NonIntegerValueException {
        if (number2 % number1 == 0) return number2/number1;

        throw new NonIntegerValueException("Quotient of operation isn't an Integer");
    }
}
