package be.skylark.weather.weathercentral.controllers;

import be.skylark.weather.darkskyclient.entities.DsIcon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

    public static final String WEATHER_ICONS = "demoWeatherIcons" ;

    @RequestMapping(method = RequestMethod.GET, value = Paths.Demo.showAllIcons)
    public String showAllIcons(final Model model) {
        model.addAttribute( WEATHER_ICONS , DsIcon.values() ) ;
        return Views.Demo.showAllIcons ;
    }

}
