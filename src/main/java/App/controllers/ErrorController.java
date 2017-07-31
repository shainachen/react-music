package App.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/killswitch")
public class ErrorController {

    @CrossOrigin
    @RequestMapping
    public void kill(){
        System.exit(1);
    }

}
