package webshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetAllProducts extends HttpServlet {
    private LinkedHashMap<String, Float> listProduct = new LinkedHashMap<>();
    @Override
    public void init() throws ServletException {
        listProduct.put("Product1", 30.50f);
        listProduct.put("Product2", 110f);
        listProduct.put("Product3", 128f);
        listProduct.put("Product4", 67.80f);
        listProduct.put("Product5", 81.20f);
        listProduct.put("Product6", 215f);
        listProduct.put("Product7", 87.60f);
        listProduct.put("Product8", 55f);
        listProduct.put("Product9", 263f);
        listProduct.put("Product10", 32.50f);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product;
        int i = 0;

        resp.getWriter().printf(
            "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>List of products</title>\n" +
                    "</head>\n" +
                    "<body>"
        );
        resp.getWriter(). println(
                "<table>\n" +
                "<caption>All products:</caption>\n" +
                "<tr>" +
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>Cost</th>" +
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
