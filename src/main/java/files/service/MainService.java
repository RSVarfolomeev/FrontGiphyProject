package files.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    private final RestTemplate restTemplate;
    @Value("${backend.url}")
    String backEndUrl;

    public MainService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String[] getGifAndCurrency(String currency) {
        String[] answer = new String[2];
            ResponseEntity<ObjectNode> responseEntity = doPost(currency, backEndUrl);
        ObjectNode response = responseEntity.getBody();

        String checkingCurrency = response.get("checkingCurrency").asText();
        double currencyDif = response.get("currencyDif").asDouble();
        answer[0] = response.get("giphyUrl").asText();
        String status = response.get("status").asText();
        if (!status.equals("Ok")) {
            answer[1] = status;
            return answer;
        }
        if (currencyDif <= 0) {
            answer[1] = checkingCurrency + " укрепляется к USD: " + currencyDif;
        } else {
            answer[1] = checkingCurrency + " ослабевает к USD: " + currencyDif;
        }
        return answer;
    }

    public ResponseEntity<ObjectNode> doPost(String model, String url) {
        HttpEntity<String> entity = getHttpEntity(model);
            return restTemplate.postForEntity(url, entity, ObjectNode.class);
    }

    private HttpEntity<String> getHttpEntity(String model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(model, httpHeaders);
    }
}
