package org.whispersystems.pushserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.whispersystems.pushserver.config.ApnConfiguration;
import org.whispersystems.pushserver.config.AuthenticationConfiguration;
import org.whispersystems.pushserver.config.GcmConfiguration;
import org.whispersystems.pushserver.config.RedisConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;

public class PushServerConfiguration extends Configuration {

  @JsonProperty
  @Valid
  @NotNull
  private AuthenticationConfiguration authentication;

  @JsonProperty
  @Valid
  @NotNull
  private RedisConfiguration redis;

  @JsonProperty
  @Valid
  private ApnConfiguration apn;

  @JsonProperty
  @Valid
  private GcmConfiguration gcm;
  
  public AuthenticationConfiguration getAuthenticationConfiguration() {

    return ForstaConfiguration.getAuthenticationConfiguration();
  }

  public GcmConfiguration getGcmConfiguration() {

    return ForstaConfiguration.getGcmConfiguration();
  }

  public ApnConfiguration getApnConfiguration() {
	  
    return ForstaConfiguration.getApnConfiguration();
  }

  public RedisConfiguration getRedisConfiguration() {

    return ForstaConfiguration.getRedisConfiguration();
  }
}
