package webshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetAllProducts extends HttpServlet {
    private HashMap<String, Float> listProduct = new HashMap<>();
    @Override
    public void init() throws ServletException {
        listProduct.put("Хлеб", 30.50f);
        listProduct.put("Курица", 110f);
        listProduct.put("Масло сливочное", 128f);
        listProduct.put("Чай черный", 67.80f);
        listProduct.put("Сыр плавленный", 81.20f);
        listProduct.put("Колбаса докторская", 215f);
        listProduct.put("Помидоры", 87.60f);
        listProduct.put("Картофель", 55f);
        listProduct.put("Конфеты шоколадные", 263f);
        listProduct.put("Молоко 1л", 32.50f);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product;
        int i = 0;
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().printf(
            "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>Spisok productov</title>\n" +
                    "</head>\n" +
                    "<body>"
        );
        resp.getWriter().printf(
                "<table>\n" +
                "<caption>Список продуктов:</caption>\n" +
                "<tr>" +
                "<th>Id</th>" +
                "<th>Имя</th>" +
                "<th>Цена</th>" +
                "</tr>"
        );
        for (Map.Entry pair : listProduct.entrySet()) {
            product = new Product(++i, (String) pair.getKey(), (Float) pair.getValue());
            resp.getWriter().printf(
                    "<tr>" +
                     "<td>" + product.getID() + "</td>" +
                            "<td>" + product.getTITLE() + "</td>" +
                            "<td>" + product.getCOST() + "</td>" +
                            "</tr>"
            );
        }
        resp.getWriter().printf("</table>" + "</body>" + "</html>");
    }
}
