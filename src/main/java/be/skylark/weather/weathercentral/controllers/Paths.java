package be.skylark.weather.weathercentral.controllers;

public interface Paths {

    String root = "/" ;

    interface Demo {
        String root = Paths.root + "demo/" ;
        String showAllIcons = Demo.root + "showAllIcons" ;
    }

}
