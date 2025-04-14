package api.store.models.device_list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResponse {
    private String id;
    private String name;
    private DeviceDataDTO data;
}
