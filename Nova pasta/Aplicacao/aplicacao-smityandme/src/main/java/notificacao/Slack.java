
package notificacao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author vinicius.n.ferreira
 */
public class Slack {
    
    //static pelo fato que não precisamos instanciar essa classe//
    //o final é por que o valor nunca será mudado//
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String url = "https://hooks.slack.com/services/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";
    
    public static void enviarMensagem(JSONObject content) throws IOException,InterruptedException{
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());      
    }
}
