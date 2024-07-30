package kz.dar.university.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String postId; //ID посылки
    @NotNull(message = "Неправильно: ID клиента")
    private String clientId; //ID клиента  (@NotNull) - поле обязательное к заполнению
    @NotNull(message = "Неправильно: ID получателя")
    private String postRecipientId; //ID получателя  (@NotNull) - поле обязательное к заполнению
    @NotNull(message = "Неправильно: Наименование посылки")
    private String postItem; //Наименование посылки (@NotNull) - поле обязательное к заполнению
    private String status; //Статус заказа
}
