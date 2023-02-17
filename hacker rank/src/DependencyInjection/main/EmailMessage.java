package DependencyInjection.main;

public class EmailMessage implements MessageService{
    @Override
    public void sendMessage(String msg) {
        System.out.println("Email:"+msg);
    }
}
