package org.whispersystems.pushserver.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.whispersystems.pushserver.auth.Server;

import javax.validation.Valid;
import java.util.*;

public class AuthenticationConfiguration {

  @JsonProperty
  @Valid
  private List<Server> servers;


  public List<Server> getServers() {
    return servers;
  }

  public AuthenticationConfiguration() {

  }

  public AuthenticationConfiguration(
    String name,
    String password)
  {
      this.servers = new ArrayList<Server>();

      Server server = new Server(name, password);

      this.servers.add(server);
  }
}
