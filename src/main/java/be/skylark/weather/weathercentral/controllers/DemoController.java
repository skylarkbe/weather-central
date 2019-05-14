package be.skylark.weather.weathercentral.controllers;

import be.skylark.weather.darkskyclient.entities.DsIcon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DemoController {

    public static final String WEATHER_ICONS = "demoWeatherIcons" ;

    @Value("${application.demo.enabled:false}")
    boolean applicationDemoEnabled ;

    @RequestMapping(method = RequestMethod.GET, value = Paths.Demo.showAllIcons)
    public String showAllIcons(final Model model) {
        if ( applicationDemoEnabled ) {
            model.addAttribute(WEATHER_ICONS, DsIcon.values());
            return Views.Demo.showAllIcons;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application demo not enabled");
    }

}
