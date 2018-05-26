package handlers;

import services.utils.Service;
import services.utils.ServiceContext;

public class Login implements Service {
    @Override
    public void serve(ServiceContext serviceContext) {
        System.out.println("Login Handler");

    }
}
