package DependencyInjection.main;

public class Main {
    public static void main(String[] args) {
        MessageService messageService = new SmsMessage();
        UserController userController = new UserController(messageService);
        userController.setMessageService(messageService);
        userController.send();
    }
}
