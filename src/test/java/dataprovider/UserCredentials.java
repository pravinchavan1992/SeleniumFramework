package dataprovider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentials {
    private String userName;
    private String password;

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.userName = password;
    }
}
