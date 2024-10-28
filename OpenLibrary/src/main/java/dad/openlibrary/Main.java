package dad.openlibrary;

import dad.openlibrary.api.OpenLibrary;
import dad.openlibrary.api.SearchResult;

import java.io.IOException;

public class Main {

        public static void main(String[] args) throws IOException {
            OpenLibrary openLibrary = new OpenLibrary();
            SearchResult result = openLibrary.getBooks("game of thrones");
            System.out.println(result.getDocs().size());
            System.out.println(result.getDocs().getFirst().getAuthorName());
        }
}
