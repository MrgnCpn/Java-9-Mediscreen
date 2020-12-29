package com.mediscreen.mspatientadmin.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${mediscreen-ms-autentication.name}", url = "${mediscreen-ms-autentication.url}")
public interface MSAuthenticationProxy {
    @GetMapping("/validate-token")
    ResponseEntity<Void> validateToken(@RequestParam("token") String token);
}
