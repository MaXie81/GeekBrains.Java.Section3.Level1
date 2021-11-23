package webshop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GetAllProducts", urlPatterns = "allProducts")
public class GetAllProducts extends HttpServlet {
    private Map<String, Float> listProduct = new HashMap<>();

    @Override
    public void init() throws ServletException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product;
        int i = 0;

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println("<html>\n<head>\n<title>Список продуктов</title>\n<body>");
        resp.getWriter().println("<table>\n<caption>Список продуктов:</caption>");
        resp.getWriter().printf("<tr><th>%s</th><th>%s</th><th>%s</th></tr>\n", "Id", "Имя", "Цена");

        for (ProductDictionary dictionaryProduct : ProductDictionary.values()) {
            product = new Product(++i, dictionaryProduct.getTitle(), dictionaryProduct.getCost());
            resp.getWriter().printf("<tr><td>%s</td><td>%s</td><td>%s</td></tr>\n", product.getID(), product.getTITLE(), product.getCOST());
        }
        resp.getWriter().println("</table></body></html>");
    }
}
