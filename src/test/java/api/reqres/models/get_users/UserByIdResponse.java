package api.reqres.models.get_users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserByIdResponse {
    private UserData data;

    public boolean isEmpty() {
        return data == null;
    }
}
