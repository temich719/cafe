package DAO.util;

public class OffsetCalculator {
    private static final OffsetCalculator INSTANCE = new OffsetCalculator();

    private OffsetCalculator() {
    }

    public static OffsetCalculator getINSTANCE() {
        return INSTANCE;
    }

    public int calculateOffset(String numberOfPage, int limit) {
        return (Integer.parseInt(numberOfPage) - 1) * limit;
    }
}
