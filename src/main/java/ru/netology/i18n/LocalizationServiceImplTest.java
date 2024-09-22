package ru.netology.i18n;

import ru.netology.entity.Country;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalizationServiceImplTest {

    @Test
    public void testLocaleRussia() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", message);
    }

    @Test
    public void testLocaleUSA() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(Country.USA);
        assertEquals("Welcome", message);
    }
}