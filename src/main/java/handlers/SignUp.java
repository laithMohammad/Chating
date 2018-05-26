package handlers;

import services.utils.Service;
import services.utils.ServiceContext;

public class SignUp implements Service {

    @Override
    public void serve(ServiceContext serviceContext) {
        System.out.println("Sign up Handler");
    }
}
