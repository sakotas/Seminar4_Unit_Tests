package seminars.fourth.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

//    Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
//    обращающийся к внешнему API для получения информации о текущей температуре.
//    Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
//    Создайте мок-объект для WeatherService с использованием Mockito.

    @Test
    void testGenerateReport(){
        // init
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        // act
        when(weatherService.getCurrentTemperature()).thenReturn(20);

        // assert
        assertEquals("Текущая температура: 20 градусов.", weatherReporter.generateReport());
        verify(weatherService).getCurrentTemperature();

    }

}