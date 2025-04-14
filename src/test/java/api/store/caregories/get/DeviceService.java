package api.store.caregories.get;

import api.store.models.device_list.DeviceResponse;
import java.util.List;

public interface DeviceService {
  List<DeviceResponse> getAllDevices();
}
