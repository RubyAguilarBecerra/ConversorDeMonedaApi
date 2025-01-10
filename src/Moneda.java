import com.google.gson.JsonObject;

public record Moneda(
        String result,
        String documentation,
        String terms_of_use,
        int time_last_update_unix,
        String time_last_update_utc,
        int time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        JsonObject conversion_rates) {  // conversion_rates es un JsonObject
}
