
import java.util.List;

public interface ResourceOperations {
    void addResource(Resource resource);
    List<Resource> getAllResources();
    List<Resource> searchResources(String keyword);
    void updateResource(Resource resource);
    void deleteResource(int resourceId);
}
