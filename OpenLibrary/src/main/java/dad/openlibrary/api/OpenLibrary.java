package dad.openlibrary.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class OpenLibrary {

    private static final String BASE_URL = "https://openlibrary.org/";

    private Gson gson;
    private OpenLibraryInterface service;

    public OpenLibrary() {

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(OpenLibraryInterface.class);
    }

    public SearchResult getBooks(String query) throws IOException {
        Response<SearchResult> result = service.search(query).execute();
        if (result.isSuccessful()) {
            return result.body();
        }
        return null;
    }

}




