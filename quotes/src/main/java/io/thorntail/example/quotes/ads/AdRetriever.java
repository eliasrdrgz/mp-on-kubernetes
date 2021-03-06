package io.thorntail.example.quotes.ads;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URL;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 10/8/18
 */
@ApplicationScoped
public class AdRetriever {

    @Inject
    @ConfigProperty(name = "adServiceUrl")
    private URL adServiceUrl;

    private AdClient client;

    @PostConstruct
    public void createAdClient() {
        client = RestClientBuilder.newBuilder()
                .baseUrl(adServiceUrl)
                .build(AdClient.class);
    }

    @Timeout(500)
    @Fallback(fallbackMethod = "mockAd")
    public Ad getAd() {
        return client.get();
    }

    private Ad mockAd() {
        Ad ad = new Ad();

        ad.setContent("Keep an eye on what's coming in Thorntail v4!");
        ad.setUrl("http://thorntail.io");
        return ad;
    }
}
