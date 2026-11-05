
public class BookResource extends Resource {

    public BookResource(String title, String category, String description,
                        String sharingType, String conditionStatus, String ownerName) {
        super(title, category, description, sharingType, conditionStatus, ownerName);
    }

    public BookResource(int resourceId, String title, String category, String description,
                        String sharingType, String conditionStatus, String ownerName,
                        String status) {
        super(resourceId, title, category, description, sharingType,
              conditionStatus, ownerName, status);
    }

    @Override
    public String getResourceType() {
        return "Book";
    }
}
