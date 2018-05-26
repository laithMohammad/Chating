package handlers;

import services.utils.Service;
import services.utils.ServiceContext;
import javax.servlet.ServletException;
import java.io.IOException;

public class ShowHome implements Service {

    @Override
    public void serve(ServiceContext serviceContext) {
        try {
            serviceContext.getHttpServletRequest().getRequestDispatcher("../index.jsp").forward(serviceContext.getHttpServletRequest(),serviceContext.getHttpServletResponse());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}