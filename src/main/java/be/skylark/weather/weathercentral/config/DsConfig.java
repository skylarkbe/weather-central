package be.skylark.weather.weathercentral.config;

import be.skylark.weather.darkskyclient.client.DarkSkyClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * This configuration class setups the DarkSky API related configuration
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DsConfig {

    Logger logger = LoggerFactory.getLogger(DsConfig.class);

    @Value("${darkSky.api.key}")
    private String dsApiKey ;

    @Value("${darkSky.api.url")
    private String dsApiURL ;

    @Value("${darkSky.api.url.forecastPath}")
    private String dsApiForecastPath ;

    @Value("${darkSky.api.url.timeMachinePath}")
    private String dsApiTimeMachinePath ;

    /**
     * Creates a DarkSky Client bean that can bes used application wide
     * @return A DarkSky singleton client
     * @throws IllegalArgumentException if any of the required parameter is missing
     */
    @Bean
    public DarkSkyClient darkSkyClient() {
        DarkSkyClient dsClient = new DarkSkyClient() ;
        if ( StringUtils.isAnyBlank(dsApiKey, dsApiURL, dsApiForecastPath, dsApiTimeMachinePath) ) {
            logger.error("DarkSky API is not properly configured ; make sure to provide the necessary arguments");
            return dsClient ;
        }
        logger.debug("Generating DarkSky client with API {} ; forecast path {} and time machine path {}", dsApiURL, dsApiForecastPath, dsApiTimeMachinePath);
        dsClient.setApiKey( dsApiKey );
        dsClient.setBaseApiUrl( dsApiURL );
        dsClient.setForecastPath( dsApiForecastPath );
        dsClient.setTimeMachinePath( dsApiTimeMachinePath );
        return dsClient ;
    }

}
