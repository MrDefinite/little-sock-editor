package org.songli.web.controller;

import org.songli.web.WebUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = WebUrls.WEB_CONTEXT_PATH, method = RequestMethod.GET)
    public String mainPage() {
        return "index";
    }

}
