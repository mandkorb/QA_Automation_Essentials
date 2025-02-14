package api.responses;

import api.models.UserData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private UserData data;

    public boolean isEmpty() {
        return data == null;
    }
}
