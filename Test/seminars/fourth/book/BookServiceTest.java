package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//    У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
//    Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.

//    Формат сдачи: воспользуйтесь одним из вариантов: Ссылка на репозиторий Git или Прикрепленный архив

//    Письменное задание 1 можно также разместить в репозитории или разместить текстом в окне сдачи практического задания.
class BookServiceTest {
    private BookService bookService;
    private BookRepository bookRepositoryMock;

    private final Book book1 = new Book("1", "Book1", "Author1");
    private final Book book2 = new Book("2", "Book2", "Author2");

    @BeforeEach
    void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);

        when(bookRepositoryMock.findById("1")).thenReturn(book1);
        when(bookRepositoryMock.findById("3")).thenReturn(null); // Для сценария "книга не найдена"
        when(bookRepositoryMock.findAll()).thenReturn(new ArrayList<>(List.of(book1, book2)));
    }

    @Test
    void findBookById_Successful() {
        Book result = bookService.findBookById("1");
        assertNotNull(result);
        assertEquals(book1, result);
        assertEquals("Book1", result.getTitle());
        verify(bookRepositoryMock, times(1)).findById("1");
    }

    @Test
    void findBookById_NotFound() {
        Book result = bookService.findBookById("3");
        assertNull(result);
        verify(bookRepositoryMock, times(1)).findById("3");
    }

    @Test
    void findAllBooksTest() {
        List<Book> result = bookService.findAllBooks();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        verify(bookRepositoryMock, times(1)).findAll();
    }
}