
public abstract class Resource {
    private int resourceId;
    private String title;
    private String category;
    private String description;
    private String sharingType;
    private String conditionStatus;
    private String ownerName;
    private String status;

    public Resource(String title, String category, String description,
                    String sharingType, String conditionStatus, String ownerName) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.sharingType = sharingType;
        this.conditionStatus = conditionStatus;
        this.ownerName = ownerName;
        this.status = "Available";
    }

    public Resource(int resourceId, String title, String category, String description,
                    String sharingType, String conditionStatus, String ownerName,
                    String status) {
        this(title, category, description, sharingType, conditionStatus, ownerName);
        this.resourceId = resourceId;
        this.status = status;
    }

    public abstract String getResourceType();

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSharingType() {
        return sharingType;
    }

    public void setSharingType(String sharingType) {
        this.sharingType = sharingType;
    }

    public String getConditionStatus() {
        return conditionStatus;
    }

    public void setConditionStatus(String conditionStatus) {
        this.conditionStatus = conditionStatus;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + resourceId +
               "\nTitle: " + title +
               "\nType: " + getResourceType() +
               "\nCategory: " + category +
               "\nDescription: " + description +
               "\nSharing Type: " + sharingType +
               "\nCondition: " + conditionStatus +
               "\nOwner: " + ownerName +
               "\nStatus: " + status;
    }
}
