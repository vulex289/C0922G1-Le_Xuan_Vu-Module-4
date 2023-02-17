package DependencyInjection.main;

public class UserController {
    private MessageService messageServic;
    public UserController(MessageService messageService) {
        this.messageServic=messageService;
    }
    public void send(){
        messageServic.sendMessage("Hello các bạn");
    }

    public void setMessageService(MessageService messageService) {
        this.messageServic = messageService;
    }
}
