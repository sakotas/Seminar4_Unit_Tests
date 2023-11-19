package seminars.fourth.database;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataProcessorTest {
//    Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
//    Условие: У вас есть класс Database с методом public List<String> query(String sql),
//    который выполняет SQLзапрос и возвращает результат.
//    Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
//    выполнения запроса и обработки результатов.

//    @BeforeEach
//    void setUp(){
//
//    }

    @Test
    void testProcessor(){
        // init
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        List<String> fakeData = new ArrayList<>();
        fakeData.add("Data1");
        fakeData.add("Data2");
        fakeData.add("Data3");
        when(database.query(anyString())).thenReturn(fakeData);

        // act
        dataProcessor.processData("Data3");

        // assert
        assertEquals(fakeData, dataProcessor.processData(anyString()));
        verify(database, times(2)).query(anyString());

    }


}