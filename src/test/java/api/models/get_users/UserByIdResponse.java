package api.models.get_users;

import api.models.data.UserData;
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
