package cz.lsvobo.demo.zonky.marketplace.client;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import cz.lsvobo.demo.zonky.marketplace.ZonkyMarketPlaceApplication;
import cz.lsvobo.demo.zonky.marketplace.client.api.MarketPlaceClient;
import cz.lsvobo.demo.zonky.marketplace.client.rest.ZonkyMarketPlaceClientRestImpl;
import cz.lsvobo.demo.zonky.marketplace.config.MarketPlaceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@RestClientTest(MarketPlaceClient.class)
@ContextConfiguration(classes = {ZonkyMarketPlaceApplication.class, MarketPlaceConfig.class})
public class ZonkyMarketPlaceClientRestImplTest {

    @Autowired
    private ZonkyMarketPlaceClientRestImpl client;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer server;

    @Before
    public void setUp() {
        server = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void shouldReceiveLoansWhenCorrectResponse() {
        server.expect(requestTo(containsString("https://api.zonky.cz/loans/marketplace?datePublished__gt=")))
                .andExpect(method(GET))
                .andExpect(header("X-Order", "-datePublished"))
                .andExpect(header("X-Size", "10"))
                .andRespond(withSuccess(getClassPathResource("/market-place-loans-response.json"), APPLICATION_JSON_UTF8));

        var response = client.readNewLoansByMaxAgeInMinutes(5, 10);

        assertThat(response.size(), is(4));
        var loan1 = response.get(0);
        assertThat(loan1.getAmount().toString(), is("180000.00"));
        assertThat(loan1.getDatePublished().toString(), is("2019-02-27T21:44:22.477Z"));
    }

    private ClassPathResource getClassPathResource(final String path) {
        return new ClassPathResource(path, getClass());
    }
}
