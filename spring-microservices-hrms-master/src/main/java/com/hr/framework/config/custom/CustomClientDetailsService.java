package com.hr.framework.config.custom;

import com.hr.framework.repo.ClientRepository;
import com.hr.framework.tools.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;


@Service
public class CustomClientDetailsService implements ClientDetailsService {

  @Override public ClientDetails loadClientByClientId(String clientId)
      throws ClientRegistrationException {
    return clientRepository.findByClientIdAlias(clientId).orElseThrow(
        () -> new ClientRegistrationException(
            String.format("Client %s does not exist!", clientId)));
  }

  private final ClientRepository clientRepository;

  @Autowired public CustomClientDetailsService(ClientRepository clientRepository) {
    Assert.defaultNotNull(clientRepository);
    this.clientRepository = clientRepository;
  }
}
