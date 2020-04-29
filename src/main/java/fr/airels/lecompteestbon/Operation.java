package fr.airels.lecompteestbon;

public class Operation {
    public static OperationResult randomCalc(int a, int b) {
        switch (getOperation()) {
            case 0:
                return new OperationResult(a+b, "+");
            case 1:
                return new OperationResult(a-b, "-");
            case 2:
                if (a != 1 && b != 1) return new OperationResult(a*b, "*");
                break;
            case 3:
                if (a%b == 0) return new OperationResult(a/b, "/");
                break;
        }

        return randomCalc(a, b);
    }

    // 0 = +, 1 = -, 2 = *, 3 = /
    private static int getOperation() {
        return (int) (Math.random() * 4);
    }

    static class OperationResult {
        int result;
        String operandUsed;

        private OperationResult(int result, String operandUsed) {
            this.result = result;
            this.operandUsed = operandUsed;
        }

        public int getResult() {
            return result;
        }

        public String getOperandUsed() {
            return operandUsed;
        }
    }
}
