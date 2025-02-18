package api.reqres.tests;

import api.reqres.models.resource.ResourceListResponse;
import api.reqres.services.ResourceService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ResourceServiceTests {
    private static final int firstPage = 1;
    private static final int itemsPerPage = 6;
    private ResourceService resourceService;

    @BeforeClass
    public void setup() {
        resourceService = new ResourceService();
    }

    @Test
    public void returnASCSortedList() {
        ResourceListResponse resources = resourceService.getResourceList();
        assertNotNull(resources);
        assertEquals(resources.getPage(), firstPage);
        assertEquals(resources.getPerPage(), itemsPerPage);
        assertNotNull(resources.getData());
        assertTrue(resources.areYearsASCSorted());
    }
}
