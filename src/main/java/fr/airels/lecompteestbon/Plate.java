package fr.airels.lecompteestbon;

import fr.airels.lecompteestbon.exceptions.NonIntegerValueException;

public class Plate {
    private int number1, number2;

    public Plate(int n1, int n2) {
        number1 = n1;
        number2 = n2;
    }

    public int getAddition() {
        return number1+number2;
    }

    public int getSubstraction() {
        int result = number1 - number2;

        return (result < 0) ? reverseSubstraction() : result;
    }

    private int reverseSubstraction() {
        return number2 - number1;
    }

    public int getMultiplication() {
        return number1*number2;
    }

    public int getDivision() throws NonIntegerValueException {
        if (number1 % number2 == 0) return number1/number2;

        return reverseDivision();
    }

    private int reverseDivision() throws NonIntegerValueException {
        if (number2 % number1 == 0) return number2/number1;

        throw new NonIntegerValueException("Quotient of operation isn't an Integer");
    }
}
