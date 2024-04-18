package pro.sky.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.service.CalculService;

@RestController
@RequestMapping("/calculator")

public class CalculContr {
    private final CalculService calculService;

    public CalculContr(CalculService calculService) {
        this.calculService = calculService;
    }

    @GetMapping(value = "/hello", produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1>Hello, World!</h1>";
    }

    @GetMapping(value ="/plus" , produces = MediaType.TEXT_HTML_VALUE)
    public String plus(@RequestParam(required = false) Integer num1,
                       @RequestParam(required = false) Integer num2) {
        String checkResult = CheckParam(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "+" + num2 + "+" + "=" + calculService.plus(num1, num2);
        }
    }

    @GetMapping(value ="/minus", produces = MediaType.TEXT_HTML_VALUE)
    public String minus(@RequestParam(required = false) Integer num1,
                        @RequestParam(required = false) Integer num2) {
        String checkResult = CheckParam(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "-" + num2 + "+" + "=" + calculService.minus(num1, num2);
        }
    }

    @GetMapping(value = "/multiply", produces = MediaType.TEXT_HTML_VALUE)
    public String multiply(@RequestParam(required = false) Integer num1,
                           @RequestParam(required = false) Integer num2) {
        String checkResult = CheckParam(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "х" + num2 + "+" + "=" + calculService.multiply(num1, num2);
        }
    }


    @GetMapping(value = "/divide", produces = MediaType.TEXT_HTML_VALUE)
    public String divide(@RequestParam(required = false) Integer num1,
                         @RequestParam(required = false) Integer num2) {
        String checkResult = CheckParam(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else if(num2 == 0) {
            return "<p style=\"color: red\">Деление на 0!</p>";
        }else{
            return num1 + "/" + num2 + "+" + "=" + calculService.divide(num1, num2);
        }
    }


    private String CheckParam(Integer num1, Integer num2) {
        if (num1 == null) {
            return "<p style=\"color: red\">Параметр num1 не передан!</p>";
        } else if (num2 == null) {
            return "<p style=\"color: red\">Параметр num2 не передан!</p>";
        }
        return null;
    }
}


