package capitalgain.domain.entities;

public enum OperationType {
    BUY("buy"),
    SELL("sell"),;

    private String enumText;

    OperationType(String enumText) {
        this.enumText = enumText;
    }

    public String getEnumText() {
        return this.enumText;
    }

    public static OperationType fromString(String text) {
        for (OperationType b : OperationType.values()) {
            if (b.enumText.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}