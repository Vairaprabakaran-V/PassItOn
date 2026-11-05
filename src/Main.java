
public class Main {
    public static void main(String[] args) {
        ResourceOperations operations = new ResourceDAO();
        PassItOnConsole application = new PassItOnConsole(operations);
        application.start();
    }
}
