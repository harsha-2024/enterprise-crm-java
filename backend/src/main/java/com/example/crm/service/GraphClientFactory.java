package com.example.crm.service;

import com.azure.identity.AuthorizationCodeCredential; import com.azure.identity.AuthorizationCodeCredentialBuilder; import com.azure.identity.ClientSecretCredential; import com.azure.identity.ClientSecretCredentialBuilder; import com.microsoft.graph.serviceclient.GraphServiceClient; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Component;

@Component public class GraphClientFactory { private final String tenantId; private final String clientId; private final String clientSecret; private final String redirectUri; public GraphClientFactory(@Value("${msft.tenantId}") String tenantId, @Value("${msft.clientId}") String clientId, @Value("${msft.clientSecret}") String clientSecret, @Value("${msft.redirectUri}") String redirectUri){ this.tenantId=tenantId; this.clientId=clientId; this.clientSecret=clientSecret; this.redirectUri=redirectUri; }
  public GraphServiceClient appClient(){ ClientSecretCredential cred = new ClientSecretCredentialBuilder().clientId(clientId).clientSecret(clientSecret).tenantId(tenantId).build(); return new GraphServiceClient(cred); }
  public GraphServiceClient delegatedClient(String authCode){ AuthorizationCodeCredential cred = new AuthorizationCodeCredentialBuilder().clientId(clientId).tenantId(tenantId).clientSecret(clientSecret).authorizationCode(authCode).redirectUrl(redirectUri).build(); return new GraphServiceClient(cred); }
}
