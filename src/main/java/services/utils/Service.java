package services.utils;

public interface Service {

    public void serve(ServiceContext serviceContext);

    static boolean isAuthenticated(ServiceContext serviceContext){
        return serviceContext.isAuthenticated();
    }
}