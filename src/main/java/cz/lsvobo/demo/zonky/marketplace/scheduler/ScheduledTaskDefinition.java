package cz.lsvobo.demo.zonky.marketplace.scheduler;

import cz.lsvobo.demo.zonky.marketplace.service.MarketPlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ScheduledTaskDefinition {

    private static final int FIVE_MINUTES_MILLISECONDS = 5 * 60 * 1000;

    private final MarketPlaceService marketPlaceService;

    @Scheduled(fixedRate = FIVE_MINUTES_MILLISECONDS)
    public void marketChecker() {
        log.debug("marketChecker() START:" + Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n");

        try {
            marketPlaceService.logLatestLoans();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        log.debug("marketChecker() END" + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n ");
    }
}
