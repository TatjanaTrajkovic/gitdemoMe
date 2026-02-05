package org.example.price;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

@ExtendWith(MockitoExtension.class)
public class PriceWatcherAsyncTest {

    @Mock
    PriceService priceService;

    @Spy
    NotificationService notificationService = new AsyncNotificationService();

    @InjectMocks
    PriceWatcher priceWatcher;

    @Test
    @Tag("slow")
    void sendNotificationWhenPriceLoweThenThreshold() throws InterruptedException {
        Mockito.when(priceService.getPrice("T-shirt"))
                .thenReturn(95);

        priceWatcher.checkPrices();

        // vi skippar detta med awaitility dependency
//        assertThat(notificationService.isSent()).isTrue();
//
//        Mockito.verify(notificationService, Mockito.times(1))
//                .notify(Mockito.anyString(), Mockito.eq(95));

        Awaitility.await().atMost(5, TimeUnit.SECONDS)
                .pollDelay(400, TimeUnit.MILLISECONDS)
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .until(notificationService::isSent);
    }

}

//spy