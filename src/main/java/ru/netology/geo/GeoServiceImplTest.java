import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.Assert.*;

public class GeoServiceImplTest {

    @Test
    public void testByIpRussia() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.32.11");
        assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    public void testByIpUSA() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("96.44.183.149");
        assertEquals(Country.USA, location.getCountry());
    }
}