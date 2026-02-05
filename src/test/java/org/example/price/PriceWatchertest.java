package org.example.price;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PriceWatchertest {

    @Mock
    PriceService priceService;

    @Mock
    NotificationService notificationService;

    @InjectMocks
    PriceWatcher priceWatcher;

    @Test
    void sendNotificationWhenPriceLowerThenThreshold(){
        Mockito.when(priceService.getPrice("T-shirt"))
                .thenReturn(95);
//        Mockito.when(priceService.getPrice("Vinterjacka"))
//                .thenReturn(1000);
        priceWatcher.checkPrices();

        Mockito.verify(notificationService,
                Mockito.times(1))
                .notify("T-shirt", 95);
    }

    @Test
    void throwsExcpetionWhenPriceServiceIsUnavailable(){
        Mockito.when(priceService.getPrice("T-shirt"))
                .thenThrow(new RuntimeException("Something went wrong"));

        var exeption = assertThrows(RuntimeException.class,
                () -> priceWatcher.checkPrices());
        assertThat(exeption).hasMessage("Error when checking prices");

    }


}
