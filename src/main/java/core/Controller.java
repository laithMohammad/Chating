package core;

import services.utils.ServiceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/action/*")
public class Controller extends HttpServlet {

    private  Dispatcher dispatcher;

    @Override
    public void init() throws ServletException {
        dispatcher = new Dispatcher();
    }

    boolean x = false;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get URI, Params
        //Create new context
        //Find Service
        //Execute
        //Return JSON response
        ServiceContext serviceContext = new ServiceContext(req, resp);
        services(serviceContext);
    }

    private void services(ServiceContext serviceContext){
        String uri = serviceContext.getUri();
        uri = uri.substring(2);
        serviceContext.setServiceName(uri);
        dispatcher.dispatch(serviceContext);
    }

    private void writeJson(){}
}