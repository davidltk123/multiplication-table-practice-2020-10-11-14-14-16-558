package com.tw;

public class MultiplicationTable {
    //P: 2mins, DCA
    public String create(int startNumber, int endNumber) {
        boolean isValid = isValid(startNumber, endNumber);
        String multiplicationTable = generateMultiplicationTable(startNumber, endNumber);
        return isValid ? multiplicationTable : null;
    }

    //P: 5mins, D: C: A
    private boolean isValid(int startNumber, int endNumber) {
        boolean isStartNumberInRange = isNumberInRange(startNumber);
        boolean endStartNumberInRange = isNumberInRange(endNumber);
        boolean isEndLargerThanStart = isEndLargerThanStart(startNumber, endNumber);
        return isStartNumberInRange && endStartNumberInRange && isEndLargerThanStart;
    }

    //P: 1min, D: 1min
    private boolean isEndLargerThanStart(int startNumber, int endNumber) {
        return startNumber <= endNumber;
    }

    //P: 2mins, D: 1min
    private boolean isNumberInRange(int number) {
        return (number > 0 && number <= 1000);
    }

    //P: 3mins, D: CA
    private String generateMultiplicationTable(int startNumber, int endNumber) {
        String multiplicationTable = "";
        for (int row = startNumber; row <= endNumber; row++) {

            multiplicationTable += generateMultiplicationLine(startNumber, row);

            if (row != endNumber) {
                multiplicationTable = multiplicationTable + "\r\n";
            }
        }
        return multiplicationTable;
    }

    //P: 5 mins
    private String generateMultiplicationLine(int startNumber, int row) {
        String multiplicationLine = "";
        for (int i = startNumber; i <= row; i++) {

            multiplicationLine += generateMultiplicationExpression(i, row);

            if (i != row) {
                multiplicationLine = multiplicationLine + "  ";
            }
        }
        return multiplicationLine;
    }

    //P: 3 mins
    private String generateMultiplicationExpression(int muliplier, int multiplicand) {
        String expression = "";
        return muliplier + "*" + multiplicand + "=" + (muliplier * multiplicand);
    }
}
