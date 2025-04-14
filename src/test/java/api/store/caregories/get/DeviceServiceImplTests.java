package api.store.caregories.get;

import java.util.List;

import api.store.models.device_list.DeviceResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class DeviceServiceImplTests {
  private DeviceService deviceService;

  @BeforeClass
  public void setUp() {
    deviceService = new DeviceServiceImpl();
  }

  @Test
  public void getAllObjects() {
    List<DeviceResponse> devices = deviceService.getAllDevices();
    assertNotNull(devices);
  }

}
