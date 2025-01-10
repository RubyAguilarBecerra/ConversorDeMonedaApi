import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consultaApi {

    public Moneda consultaMoneda(String tipoMoneda) {
        // API URL para obtener las tasas de cambio
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a9160adaf3a9b962e7177be4/latest/" + tipoMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviamos la solicitud y obtenemos la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Deserializamos la respuesta JSON a un objeto de tipo Moneda
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            // Si hay un error, lanzamos una excepción
            throw new RuntimeException("No se pudo obtener la información de la moneda: " + e.getMessage());
        }
    }
}
