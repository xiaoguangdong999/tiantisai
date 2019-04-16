package top.axbt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("top.axbt.keshe.dao")
@RestController
public class KesheApplication {

   /* @RequestMapping("/")
    public String hello(){
        return "hello world";
    }*/

    public static void main(String[] args) {
        SpringApplication.run(KesheApplication.class, args);
    }
}
