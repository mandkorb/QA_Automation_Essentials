package api.reqres.models.get_users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersListResponse {
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    private List<UserData> data;

    public boolean areUserEmailsEndWithDomain(String domain) {
        return data.stream().allMatch(user ->
                user.getEmail().endsWith(domain));
    }

    public boolean areAvatarsContainUserId() {
        return data.stream().allMatch(user ->
                user.getAvatar().contains(String.valueOf(user.getId())));
    }
}
