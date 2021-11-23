package webshop;

public enum ProductDictionary {
    PRODUCT_1("Хлеб", 30.50f),
    PRODUCT_2("Курица", 110f),
    PRODUCT_3("Масло сливочное", 128f),
    PRODUCT_4("Чай черный", 67.80f),
    PRODUCT_5("Сыр плавленный", 81.20f),
    PRODUCT_6("Колбаса докторская", 215f),
    PRODUCT_7("Помидоры", 87.60f),
    PRODUCT_8("Картофель", 55f),
    PRODUCT_9("Конфеты шоколадные", 263f),
    PRODUCT_10("Молоко 1л", 32.50f);

    private String title;
    private Float cost;
    ProductDictionary(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }
    String getTitle() {return title;};
    Float getCost() {return cost;};
}
