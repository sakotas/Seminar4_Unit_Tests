package seminars.fourth.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

//    Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
//    Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
//    который обычно проверяет, доступен ли номер в отеле.
//    Вам необходимо проверить правильность работы класса BookingService, который
//    использует HotelService для бронирования номера, если он доступен

    @Test
    void bookRoomAvailableTest() {
        // init
        HotelService hotelServiceMock = mock(HotelService.class);
        when(hotelServiceMock.isRoomAvailable(anyInt())).thenReturn(true);

        // act
        BookingService bookingService = new BookingService(hotelServiceMock);
        boolean result = bookingService.bookRoom(101);

        // assert
        assertTrue(result);
        verify(hotelServiceMock).isRoomAvailable(101);
    }

    @Test
    void bookRoomUnavailableTest() {
        // init
        HotelService hotelServiceMock = mock(HotelService.class);
        when(hotelServiceMock.isRoomAvailable(anyInt())).thenReturn(false);

        // act
        BookingService bookingService = new BookingService(hotelServiceMock);
        boolean result = bookingService.bookRoom(101);

        // assert
        assertFalse(result);
        verify(hotelServiceMock).isRoomAvailable(101);
    }

}