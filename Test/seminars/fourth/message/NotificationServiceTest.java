package seminars.fourth.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {
    //    Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
    //    Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
    //    recipient), который отправляет сообщение получателю.
    //    Вам необходимо проверить правильность работы класса NotificationService, который использует
    //    MessageService для отправки уведомлений.
    @Mock
    private MessageService messageService;

    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        notificationService = new NotificationService(messageService);
    }

    @Test
    void sendMessageSuccessfully() {
        String message = "Test Message";
        String recipient = "test@example.com";

        // Вызов метода для отправки уведомления
        notificationService.sendNotification(message, recipient);

        // Проверка, что метод sendMessage был вызван с правильными параметрами
        verify(messageService, times(1)).sendMessage(message, recipient);
    }
}