package kz.dar.university.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private String postId;
    private String clientId;
    private String postRecipientId;
    private String postItem;
    private String status;
}
