package com.gft.mongo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by Michał on 2015-05-28.
 */
public class HelloWorldSparkAndFreemarker {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldSparkAndFreemarker.class, "/freemarker");

        Spark.get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            try {
                Template template = config.getTemplate("hello.ftl");
                Map<String, Object> params = new HashMap<>();
                params.put("name", "Dupa");
                template.process(params, writer);
            } catch (IOException | TemplateException e) {
                halt(500);
                e.printStackTrace();
            }
            return writer;
        });
    }
}
