package cz.lsvobo.demo.zonky.marketplace.client.rest;

import static cz.lsvobo.demo.zonky.marketplace.client.rest.enums.MarketVariable.DATE_PUBLISHED;
import static cz.lsvobo.demo.zonky.marketplace.client.rest.enums.SortDirection.DESC;
import static org.springframework.http.HttpMethod.GET;

import cz.lsvobo.demo.zonky.marketplace.client.api.MarketPlaceClient;
import cz.lsvobo.demo.zonky.marketplace.client.api.model.Loan;
import cz.lsvobo.demo.zonky.marketplace.client.rest.enums.MarketVariable;
import cz.lsvobo.demo.zonky.marketplace.client.rest.enums.SortDirection;
import cz.lsvobo.demo.zonky.marketplace.client.rest.exception.MarketPlaceClientException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
public class ZonkyMarketPlaceClientRestImpl implements MarketPlaceClient {

    private static final String HEADER_X_ORDER = "X-Order";
    private static final String HEADER_X_SIZE = "X-Size";

    @Value("${zonky.api.url}")
    private String zonkyApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Loan> readNewLoansByMaxAgeInMinutes(final Integer ageInMinutes, final Integer maxRecords) {
        try {
            var entity = buildHttpEntity(maxRecords, DATE_PUBLISHED, DESC);

            var offsetDateTime = LocalDateTime.now().minusMinutes(ageInMinutes);

            var url = UriComponentsBuilder.fromHttpUrl(zonkyApiUrl)
                    .queryParam(DATE_PUBLISHED.getVariableName() + "__gt", offsetDateTime.toString())
                    .build()
                    .toUriString();

            var response = restTemplate.exchange(url, GET, entity, new ParameterizedTypeReference<List<Loan>>() {});

            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new MarketPlaceClientException("Unexpected client error: " + e.getResponseBodyAsString(), e);
        } catch (HttpServerErrorException e) {
            throw new MarketPlaceClientException("Unexpected server error: " + e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            throw new MarketPlaceClientException("Unexpected error", e);
        }
    }

    private HttpEntity buildHttpEntity(
            final Integer maxRecords,
            final MarketVariable orderVariableName,
            final SortDirection sortDirection) {
        var headers = new HttpHeaders();
        headers.set(HEADER_X_ORDER, sortDirection.getDirection() + orderVariableName.getVariableName());
        headers.set(HEADER_X_SIZE, maxRecords.toString());
        return new HttpEntity(headers);
    }
}
