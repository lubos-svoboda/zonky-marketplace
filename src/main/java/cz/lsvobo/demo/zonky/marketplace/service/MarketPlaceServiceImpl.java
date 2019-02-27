package cz.lsvobo.demo.zonky.marketplace.service;

import cz.lsvobo.demo.zonky.marketplace.client.api.MarketPlaceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarketPlaceServiceImpl implements MarketPlaceService {

    private static final int AGE_IN_MINUTES = 60;
    private static final int MAX_RECORDS = 10;

    private final MarketPlaceClient marketPlace;

    @Override
    public void logLatestLoans() {
        var loans = marketPlace.readNewLoansByMaxAgeInMinutes(AGE_IN_MINUTES, MAX_RECORDS);
        loans.forEach(l -> log.info(l.toString()));
    }
}
