package com.example.demo.helper;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import java.util.Base64;

@Component
public class JWThelper {

    public String getSecretKey(String token) {
        token=token.replaceAll("Credential=", "");
        token=token.replaceAll("credential=", "");
        String[] parts = token.split("\\."); // Split the token into parts

        // Decode the header and payload
        String header = new String(Base64.getUrlDecoder().decode(parts[0]));
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

        // Convert to JSON objects
        JSONObject headerJson = new JSONObject(header);
        JSONObject payloadJson = new JSONObject(payload);
        return payloadJson.getString("email");
    }
}
