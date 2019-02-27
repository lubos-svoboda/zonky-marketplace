package cz.lsvobo.demo.zonky.marketplace.client.rest.enums;

public enum SortDirection {
    ASC("+"), DESC("-");

    private String direction;

    SortDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
