package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author internet
 *
 */
@Controller
public class IndexController {


  @RequestMapping({"", "/", "index", "index.html", "index.htm", "index.jsp"})
  public String index() {
    return "index";
  }
}
