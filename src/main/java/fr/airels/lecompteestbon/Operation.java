package fr.airels.lecompteestbon;

public class Operation {
    public static int randomCalc(int a, int b) {
        switch (getOperation()) {
            case 0:
                return a+b;
            case 1:
                return a-b;
            case 2:
                if (a != 1 && b != 1) return a*b;
                break;
            case 3:
                if (a%b == 0) return a/b;
                break;
        }

        return randomCalc(a, b);
    }

    // 0 = +, 1 = -, 2 = *, 3 = /
    private static int getOperation() {
        return (int) (Math.random() * 4);
    }
}
