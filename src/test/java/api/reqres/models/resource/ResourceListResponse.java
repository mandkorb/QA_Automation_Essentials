package api.reqres.models.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceListResponse {
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private List<ResourceData> data;

    public boolean areYearsASCSorted() {
        List<Integer> years = data.stream()
                .map(resource -> Integer.parseInt(resource.getYear()))
                .collect(Collectors.toList());
        List<Integer> yearsSorted = years.stream().sorted().collect(Collectors.toList());
        return yearsSorted.equals(years);
    }
}
