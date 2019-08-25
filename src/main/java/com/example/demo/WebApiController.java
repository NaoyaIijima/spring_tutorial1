package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API のサンプルコントローラ.
 * 
 * <p>
 * {@code application.properties#server.port = 9999} と設定していると仮定して、
 * {@code "localhost:9999/sample/api/test/*"} にアクセスする。
 * </p>
 */
@RestController
@RequestMapping("/sample/api")
public class WebApiController {
    private static final Logger log = LoggerFactory.getLogger( WebApiController.class );

    @RequestMapping("/test/{param}")
    private String testPathVariable( @PathVariable String param ) {
        log.info( param );
        return "受け取ったパラメータ：" + param;
    }

    @RequestMapping("/test")
    private String testRequestParam( @RequestParam() String param ) {
        log.info( param );
        return "受け取ったパラメータ：" + param;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    private String testRequestBody( @RequestBody String body ) {
        log.info( body );
        return "受け取ったリクエストボディ：" + body;
    }
}