package org.songli.web.controller;

import org.songli.web.WebUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping(value = WebUrls.UI_CONTEXT, method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }

}
