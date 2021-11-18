package OmdbApi;

public class OmdbController {
    private String jsonResponse;
    public void setJsonResponse (String response) { jsonResponse = response; }
    public String getJsonResponse () { return jsonResponse; }

    OmdbController() {}
    OmdbController(String response) {
        jsonResponse = response;
    }
}
