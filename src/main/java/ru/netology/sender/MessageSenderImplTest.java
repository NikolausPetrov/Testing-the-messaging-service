import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSenderImpl messageSender;

    @Before
    public void setup() {
        geoService = mock(GeoService.class);
        localizationService = mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void testSendRussianForRussianIp() {
        String russianIp = "172.0.32.11";
        Location locationRussia = new Location("Moscow", Country.RUSSIA, null, 0);

        when(geoService.byIp(russianIp)).thenReturn(locationRussia);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<>();
        headers.put("x-forwarded-for", russianIp);

        String message = messageSender.send(headers);
        assertEquals("Добро пожаловать", message);
    }

    @Test
    public void testSendEnglishForAmericanIp() {
        String americanIp = "96.44.183.149";
        Location locationUSA = new Location("New York", Country.USA, null, 0);

        when(geoService.byIp(americanIp)).thenReturn(locationUSA);
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<>();
        headers.put("x-forwarded-for", americanIp);

        String message = messageSender.send(headers);
        assertEquals("Welcome", message);
    }
}