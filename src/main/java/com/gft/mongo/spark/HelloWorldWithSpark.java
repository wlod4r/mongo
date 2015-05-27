package com.gft.mongo.spark;

import spark.Spark;

/**
 * Created by Michał on 2015-05-27.
 */
public class HelloWorldWithSpark {

    public static void main(String[] args) {
        Spark.get("/", (req, res) -> "Hello Spark!");
    }
}
