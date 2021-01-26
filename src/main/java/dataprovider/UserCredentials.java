package dataprovider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentials {
    private String UserName;
    private String Password;

    public UserCredentials(String userName, String password) {
        this.UserName = userName;
        this.Password = password;
    }
}
