package DependencyInjection.main;

public class SmsMessage implements MessageService{
    @Override
    public void sendMessage(String msg) {
        System.out.println("Sms:"+msg);
    }
}
