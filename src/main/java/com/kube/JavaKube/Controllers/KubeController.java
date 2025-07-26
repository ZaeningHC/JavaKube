package com.kube.JavaKube.Controllers;

import com.kube.JavaKube.Models.Kube;
import com.kube.JavaKube.Services.KubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/java")
public class KubeController {

    private final KubeService kubeService;

    @Autowired
    public KubeController(KubeService kubeService) {
        this.kubeService = kubeService;
    }

    @GetMapping("/kube")
    public ResponseEntity<Kube> getKube() {
        Kube sampleKube = new Kube();
        sampleKube.setId(1);
        sampleKube.setName("Sample Kube");
        sampleKube.setDescription("This is a test object from the Java API.");
        return ResponseEntity.ok(sampleKube);
    }

    @PostMapping("/receive")
    public ResponseEntity<String> receiveKube(@RequestBody Kube kube) {
        System.out.println("Received Kube object: " + kube);
        return ResponseEntity.ok("Kube data received successfully!");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendKube(@RequestBody Kube kube) {
        System.out.println("Sending Kube object to C# API: " + kube);
        String response = kubeService.sendKubeToCSharpApi(kube);
        return ResponseEntity.ok(response);
    }
}