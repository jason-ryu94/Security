package springsecurity.login.app.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String userPassword;
}
