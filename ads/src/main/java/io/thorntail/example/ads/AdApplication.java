package io.thorntail.example.ads;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 10/4/18
 */
@ApplicationPath("/rest")
@LoginConfig(authMethod = "MP-JWT", realmName = "MP-JWT")
public class AdApplication extends Application {
}
