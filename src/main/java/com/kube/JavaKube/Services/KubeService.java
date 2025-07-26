package com.kube.JavaKube.Services;

import com.kube.JavaKube.Models.Kube;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class KubeService {

    private final RestTemplate restTemplate;

    public KubeService() {
        this.restTemplate = new RestTemplate();
    }

    public String sendKubeToCSharpApi(Kube kube) {
        String csharpApiUrl = "http://csharp-api:5000/api/kube/receive";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Kube> entity = new HttpEntity<>(kube, headers);

        ResponseEntity<String> response = restTemplate.exchange(csharpApiUrl, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}