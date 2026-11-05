
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDAO implements ResourceOperations {

    @Override
    public void addResource(Resource resource) {
        String sql = "INSERT INTO resources (resource_type, title, category, description, sharing_type, condition_status, owner_name, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, resource.getResourceType());
            ps.setString(2, resource.getTitle());
            ps.setString(3, resource.getCategory());
            ps.setString(4, resource.getDescription());
            ps.setString(5, resource.getSharingType());
            ps.setString(6, resource.getConditionStatus());
            ps.setString(7, resource.getOwnerName());
            ps.setString(8, resource.getStatus());

            ps.executeUpdate();
            System.out.println("Resource added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding resource: " + e.getMessage());
        }
    }

    @Override
    public List<Resource> getAllResources() {
        List<Resource> resources = new ArrayList<>();
        String sql = "SELECT * FROM resources";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resources.add(createResource(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving resources: " + e.getMessage());
        }

        return resources;
    }

    @Override
    public List<Resource> searchResources(String keyword) {
        List<Resource> resources = new ArrayList<>();
        String sql = "SELECT * FROM resources WHERE title LIKE ? OR category LIKE ? OR owner_name LIKE ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String search = "%" + keyword + "%";

            ps.setString(1, search);
            ps.setString(2, search);
            ps.setString(3, search);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resources.add(createResource(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching resources: " + e.getMessage());
        }

        return resources;
    }

    @Override
    public void updateResource(Resource resource) {
        String sql = "UPDATE resources SET title=?, category=?, description=?, sharing_type=?, condition_status=?, owner_name=?, status=? WHERE resource_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, resource.getTitle());
            ps.setString(2, resource.getCategory());
            ps.setString(3, resource.getDescription());
            ps.setString(4, resource.getSharingType());
            ps.setString(5, resource.getConditionStatus());
            ps.setString(6, resource.getOwnerName());
            ps.setString(7, resource.getStatus());
            ps.setInt(8, resource.getResourceId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Resource updated successfully!");
            } else {
                System.out.println("Resource ID not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating resource: " + e.getMessage());
        }
    }

    @Override
    public void deleteResource(int resourceId) {
        String sql = "DELETE FROM resources WHERE resource_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, resourceId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Resource deleted successfully!");
            } else {
                System.out.println("Resource ID not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting resource: " + e.getMessage());
        }
    }

    private Resource createResource(ResultSet rs) throws SQLException {
        int id = rs.getInt("resource_id");
        String type = rs.getString("resource_type");
        String title = rs.getString("title");
        String category = rs.getString("category");
        String description = rs.getString("description");
        String sharingType = rs.getString("sharing_type");
        String condition = rs.getString("condition_status");
        String owner = rs.getString("owner_name");
        String status = rs.getString("status");

        if ("Book".equalsIgnoreCase(type)) {
            return new BookResource(id, title, category, description,
                    sharingType, condition, owner, status);
        }

        return new GeneralResource(id, title, category, description,
                sharingType, condition, owner, status);
    }
}
