//-----------------------------------------------------------------------------
// <copyright file="ForstaConfiguration.java" company="Forsta">
// Copyright © 2017
// </copyright>
//-----------------------------------------------------------------------------
package org.whispersystems.pushserver;

import org.whispersystems.pushserver.config.ApnConfiguration;
import org.whispersystems.pushserver.config.AuthenticationConfiguration;
import org.whispersystems.pushserver.config.GcmConfiguration;
import org.whispersystems.pushserver.config.RedisConfiguration;

/**
 * ---------------------------------------------------------------------------
 * 
 * This provides configuration customizations for Forsta. This server will
 * ultimately be deployed on Heroku, and thus will want to rely on variables.
 * configured in the environment.
 * 
 * ----------------------------------------------------------------------------
 */
public class ForstaConfiguration {
    
    /**
     * -----------------------------------------------------------------------
     * 
     * Return the Server authentication configuration from the environment
     * variables.
     *
     * ------------------------------------------------------------------------
     */
    public static AuthenticationConfiguration getAuthenticationConfiguration() {

        String user     = System.getenv("AUTH_SERVER_USERNAME");
        String password = System.getenv("AUTH_SERVER_PASSWORD");
        
        return new AuthenticationConfiguration(user, password);
    }

    /**
     * -----------------------------------------------------------------------
     * 
     * Return the GCM configuration from the environment variables.
     *
     * ------------------------------------------------------------------------
     */
    public static GcmConfiguration getGcmConfiguration() {

        String apiKey         = System.getenv("GCM_APIKEY");
        String senderId       = System.getenv("GCM_SENDERID");
        String xmpp           = System.getenv("GCM_XMPP");
        String redphoneApiKey = System.getenv("GCM_REDPHONEAPIKEY");

        return new GcmConfiguration(apiKey, Long.parseLong(senderId), Boolean.parseBoolean(xmpp), redphoneApiKey);
    }

    /**
     * -----------------------------------------------------------------------
     * 
     * Return the API configuration from the environment variables.
     *
     * ------------------------------------------------------------------------
     */
    public static ApnConfiguration getApnConfiguration() {

        String pemKey         = System.getenv("APN_KEY");
        String pemCertificate = System.getenv("APN_CERT");
        String feedback       = System.getenv("APN_FEEDBACK");

        return new ApnConfiguration(pemCertificate, pemKey, Boolean.parseBoolean(feedback));
    }

    /**
     * -----------------------------------------------------------------------
     * 
     * Return the Redis configuration from the environment variables.
     *
     * ------------------------------------------------------------------------
     */
    public static RedisConfiguration getRedisConfiguration() {

        String url = System.getenv("REDIS_URL");

        return new RedisConfiguration(url);
    }
}
