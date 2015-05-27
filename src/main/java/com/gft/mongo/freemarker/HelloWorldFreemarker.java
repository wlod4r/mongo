package com.gft.mongo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 2015-05-27.
 */
public class HelloWorldFreemarker {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldFreemarker.class, "/freemarker");
        try {
            StringWriter writer = new StringWriter();
            Template template = config.getTemplate("hello.ftl");
            Map<String, Object> params = new HashMap<>();
            params.put("name", "Dupa");
            template.process(params, writer);

            System.out.println(writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

}
