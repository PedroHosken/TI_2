package cc.ti2;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (request, response) -> "Hello World");
    }
}