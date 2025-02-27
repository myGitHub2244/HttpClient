package co.pragra.learning.resttemplatedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

      private String login;
      private int id;
      private String nodeId;
      private String avatarUrl;

}
