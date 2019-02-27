package cz.lsvobo.demo.zonky.marketplace.client.rest.enums;

public enum MarketVariable {
    DATE_PUBLISHED("datePublished");

    private String variableName;

    MarketVariable(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }
}
