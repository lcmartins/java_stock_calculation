package capitalgain.adapters;

import capitalgain.adapters.request.OperationRequest;
import capitalgain.domain.entities.Operation;
import capitalgain.domain.ports.IOperationReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HttpRequestReader implements IOperationReader {
    HttpClient httpClient;

    public HttpRequestReader() {
        this.httpClient = HttpClient.newBuilder()
                .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ALL))
                .build();
    }


    @Override
    public List<Operation> read() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://mocki.io/v1/b4254740-aecd-4641-986f-90415d2ba38b"))
                    .GET()
                    .build();
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            String result = response.body();
            List<OperationRequest> responseObjects = Arrays.asList(mapper.reader().readValue(result.getBytes(StandardCharsets.UTF_8), OperationRequest[].class));
            return responseObjects.stream().map(o->o.parseToDomain()).collect(Collectors.toList());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}