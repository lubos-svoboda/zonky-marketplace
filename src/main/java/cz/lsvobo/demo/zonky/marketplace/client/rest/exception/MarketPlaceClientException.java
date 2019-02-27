package cz.lsvobo.demo.zonky.marketplace.client.rest.exception;

public class MarketPlaceClientException extends RuntimeException {

    public MarketPlaceClientException(String message, Exception e) {
        super(message, e);
    }
}
