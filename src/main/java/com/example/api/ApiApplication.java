package com.example.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiApplication {

	public static void main( String[] args ) throws Exception {
        apiweka cluster = new apiweka();
        cluster.testWekaCluster();
    }


}
