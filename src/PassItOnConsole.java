
import java.util.List;
import java.util.Scanner;

public class PassItOnConsole {
    private final Scanner scanner;
    private final ResourceOperations resourceOperations;

    public PassItOnConsole(ResourceOperations resourceOperations) {
        this.scanner = new Scanner(System.in);
        this.resourceOperations = resourceOperations;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("             PASSITON");
            System.out.println(" Share what you can. Find what you need.");
            System.out.println("=================================");
            System.out.println("1. Add Resource");
            System.out.println("2. View All Resources");
            System.out.println("3. Search Resources");
            System.out.println("4. Update Resource");
            System.out.println("5. Delete Resource");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    addResource();
                    break;
                case 2:
                    viewResources(resourceOperations.getAllResources());
                    break;
                case 3:
                    searchResources();
                    break;
                case 4:
                    updateResource();
                    break;
                case 5:
                    deleteResource();
                    break;
                case 6:
                    System.out.println("Thank you for using PassItOn!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    private void addResource() {
        System.out.println("\n--- Add Resource ---");

        System.out.println("1. Book");
        System.out.println("2. General Resource");
        System.out.print("Choose resource type: ");

        int type = readInt();

        if (type != 1 && type != 2) {
            System.out.println("Invalid resource type.");
            return;
        }

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter sharing type (Donate/Borrow): ");
        String sharingType = scanner.nextLine();

        System.out.print("Enter condition (New/Good/Used): ");
        String condition = scanner.nextLine();

        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();

        if (title.isBlank() || category.isBlank() || owner.isBlank()) {
            System.out.println("Title, category and owner cannot be empty.");
            return;
        }

        Resource resource;

        if (type == 1) {
            resource = new BookResource(title, category, description,
                    sharingType, condition, owner);
        } else {
            resource = new GeneralResource(title, category, description,
                    sharingType, condition, owner);
        }

        resourceOperations.addResource(resource);
    }

    private void viewResources(List<Resource> resources) {
        System.out.println("\n--- Resource List ---");

        if (resources.isEmpty()) {
            System.out.println("No resources found.");
            return;
        }

        for (Resource resource : resources) {
            System.out.println("\n-----------------------------");
            System.out.println(resource);
        }
    }

    private void searchResources() {
        System.out.print("\nEnter title, category or owner to search: ");
        String keyword = scanner.nextLine();

        viewResources(resourceOperations.searchResources(keyword));
    }

    private void updateResource() {
        System.out.print("\nEnter resource ID to update: ");
        int id = readInt();

        Resource selected = null;

        for (Resource resource : resourceOperations.getAllResources()) {
            if (resource.getResourceId() == id) {
                selected = resource;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Resource ID not found.");
            return;
        }

        System.out.println("\nCurrent Resource Details:");
        System.out.println(selected);

        System.out.print("\nEnter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new category: ");
        String category = scanner.nextLine();

        System.out.print("Enter new description: ");
        String description = scanner.nextLine();

        System.out.print("Enter new sharing type: ");
        String sharingType = scanner.nextLine();

        System.out.print("Enter new condition: ");
        String condition = scanner.nextLine();

        System.out.print("Enter new owner name: ");
        String owner = scanner.nextLine();

        System.out.print("Enter new status (Available/Unavailable): ");
        String status = scanner.nextLine();

        if (title.isBlank() || category.isBlank() || owner.isBlank()) {
            System.out.println("Title, category and owner cannot be empty.");
            return;
        }

        selected.setTitle(title);
        selected.setCategory(category);
        selected.setDescription(description);
        selected.setSharingType(sharingType);
        selected.setConditionStatus(condition);
        selected.setOwnerName(owner);
        selected.setStatus(status);

        resourceOperations.updateResource(selected);
    }

    private void deleteResource() {
        System.out.print("\nEnter resource ID to delete: ");
        int id = readInt();

        resourceOperations.deleteResource(id);
    }

    private int readInt() {
        while (true) {
            String value = scanner.nextLine();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
