package handlers;

import services.utils.Service;
import services.utils.ServiceContext;

public class SendMessage implements Service {

    @Override
    public void serve(ServiceContext serviceContext) {
        System.out.println("Send Message Handler");

    }
}
