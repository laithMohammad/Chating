package handlers;

import services.utils.Service;
import services.utils.ServiceContext;

public class Logout implements Service {
    @Override
    public void serve(ServiceContext serviceContext) {
        System.out.println("Logout Handler");

    }
}
