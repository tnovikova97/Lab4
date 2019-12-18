package Controller;

import Bean.Earrings;
import Dao.EarringsDao;
import Dao.EarringsDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EarringsServlet")
public class EarringsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String NEW_OR_UPDATE = "/EarringsNewUpdate.jsp";
    private static String LIST = "/Earrings.jsp";

    private EarringsDao earringsDao = EarringsDaoImpl.getInstance();

    public EarringsServlet() {
        // Do Nothing
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        Earrings earrings = new Earrings();
        earrings.setTitle(request.getParameter("title"));
        earrings.setStyle(request.getParameter("style"));
        earrings.setDesigner(request.getParameter("designer"));
        earrings.setStone(request.getParameter("stone"));
        earrings.setMetal(request.getParameter("metal"));
        earrings.setPrice(Integer.parseInt(request.getParameter("price")));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            earringsDao.saveEarrings(earrings);
        } else {
            earrings.setId(Integer.parseInt(id));
            earringsDao.updateEarrings(earrings);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("ear", earringsDao.getAllEarrings());
        view.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("ID =" + id);
            Earrings earrings = new Earrings();
            earrings.setId(id);

            earringsDao.deleteEarrings(earrings);
            System.out.println("Deleted");

            forward = LIST;
            request.setAttribute("ear", earringsDao.getAllEarrings());
            System.out.println("С удалением справляюсь");
        } else if (action.equalsIgnoreCase("update")) {
            forward = NEW_OR_UPDATE;
            int id = Integer.parseInt(request.getParameter("id"));
            Earrings earrings = earringsDao.getEarringsById(id);
            request.setAttribute("ear", earrings);
            System.out.println("С обновлением справляюсь");
        } else if (action.equalsIgnoreCase("listEarrings")) {
            forward = LIST;
            request.setAttribute("ear", earringsDao.getAllEarrings());
            System.out.println("Показать тоже могу");
        } else {
            forward = NEW_OR_UPDATE;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }
}
