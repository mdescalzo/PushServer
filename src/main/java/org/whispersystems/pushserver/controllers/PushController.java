package org.whispersystems.pushserver.controllers;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.whispersystems.pushserver.auth.Server;
import org.whispersystems.pushserver.entities.ApnMessage;
import org.whispersystems.pushserver.entities.GcmMessage;
import org.whispersystems.pushserver.senders.APNSender;
import org.whispersystems.pushserver.senders.GCMSender;
import org.whispersystems.pushserver.senders.TransientPushFailureException;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import io.dropwizard.auth.Auth;

@Path("/api/v1/push")
public class PushController {

  private final APNSender apnSender;
  private final GCMSender gcmSender;
  private final Logger logger = LoggerFactory.getLogger(PushController.class);

  public PushController(APNSender apnSender, GCMSender gcmSender) {
    this.apnSender = apnSender;
    this.gcmSender = gcmSender;
  }

  @Timed
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/gcm")
  public void sendGcmPush(@Auth Server server, @Valid GcmMessage gcmMessage) {
    if (gcmSender == null) {
      logger.warn("GCM API request ignored due to missing GCM config");
      return;
    }
    gcmSender.sendMessage(gcmMessage);
  }

  @Timed
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/apn")
  public void sendApnPush(@Auth Server server, @Valid ApnMessage apnMessage)
      throws TransientPushFailureException {
    if (apnSender == null) {
      logger.warn("APN API request ignored due to missing APN config");
      return;
    }
    apnSender.sendMessage(apnMessage);
  }

}
