package cz.lsvobo.demo.zonky.marketplace.client.api;

import cz.lsvobo.demo.zonky.marketplace.client.api.model.Loan;
import java.util.List;

public interface MarketPlaceClient {

    /**
     * Read newly published loans with defined maximum age in minutes.
     * @param ageInMinutes maximum age of loan in minutes
     * @param maxRecords maximum number of records
     * @return list of loans
     */
    List<Loan> readNewLoansByMaxAgeInMinutes(Integer ageInMinutes, Integer maxRecords);
}
