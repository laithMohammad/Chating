package services;

public class ServiceLocator {
    private static ServiceLocator serviceLocator;

    static {
        serviceLocator = new ServiceLocator();
    }

    private ServiceLocator(){

    }

    public static ServiceLocator getInstance(){
        return serviceLocator;
    }



//    public EJBObject getService(String id)
//            throws ServiceLocatorException {
//        if (id == null) {
//            throw new ServiceLocatorException(...);
//        }
//        try {
//            byte[] bytes = new String(id).getBytes();
//            InputStream io = new ByteArrayInputStream(bytes);
//            ObjectInputStream os = new ObjectInputStream(io);
//            javax.ejb.Handle handle = (javax.ejb.Handle)os.readObject();
//            return handle.getEJBObject();
//        } catch(Exception ex) {
//            throw new ServiceLocatorException(...);
//        }
//    }
}