package core;

import services.utils.Service;
import services.utils.ServiceContext;
import services.utils.XMLServiceReader;

import java.util.Map;

public class Dispatcher {
    private Map<String, Service> serviceMap;

    public Dispatcher() {
        serviceMap = XMLServiceReader.servicesLoader();
    }

    public void dispatch(ServiceContext serviceContext){
        if(serviceMap.containsKey(serviceContext.getServiceName())){
            serviceMap.get(serviceContext.getServiceName()).serve(serviceContext);
        } else {
            serviceMap.get("showHome").serve(serviceContext);
        }
    }
}