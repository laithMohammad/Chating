package handlers;

import services.utils.Service;
import services.utils.ServiceContext;

public class FriendRequest implements Service {

    @Override
    public void serve(ServiceContext serviceContext) {
        System.out.println("Friend Request Handler");
    }
}