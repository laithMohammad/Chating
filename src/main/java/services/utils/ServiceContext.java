package services.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

public class ServiceContext {
    private boolean authenticated;
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    private String uri, serviceName;
    private Map<String, String[]> params;
    private EntityManager entityManager;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ServiceContext(HttpServletRequest req, HttpServletResponse res){
        this(req.getRequestURI(), "", req.getParameterMap());
        this.httpServletRequest = req;
        this.httpServletResponse = res;
        //TODO: Make a resource find the Service Name from the URI
    }

    public ServiceContext(String uri, String serviceName, Map<String, String[]> params) {
        this.uri = uri;
        this.serviceName = serviceName;
        this.params = params;
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Map<String, String[]> getParams() {
        return params;
    }

    public void setParams(Map<String, String[]> params) {
        this.params = params;
    }

    public void addParam(String paramName, String paramValue){
        if(this.params.containsKey(paramName)){
            Arrays.fill(this.params.get(paramName), paramValue);
        } else {
            this.params.put(paramName, new String[] {paramValue});
        }
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
}