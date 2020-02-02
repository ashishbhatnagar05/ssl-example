package com.ssl.example.sslexample;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SslExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SslExampleApplication.class, args);
  }
}

@RestController
class SSLTester {

  @Autowired private RestTemplate restTemplate;

  @GetMapping(value = "/ssltest")
  public String testSSL() {

    HttpEntity<ResponseModel> httpEntity = new HttpEntity<>(new ResponseModel());
    ResponseEntity<ResponseModel> response =
        restTemplate.exchange(
            "https://reqres.in/api/users/2", HttpMethod.GET, httpEntity, ResponseModel.class);
    return response.getBody().getData().getFirst_name();
  }
}
// {
//        "data": {
//        "id": 2,
//        "email": "janet.weaver@reqres.in",
//        "first_name": "Janet",
//        "last_name": "Weaver",
//        "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
//        }
//        }
