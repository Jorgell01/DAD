package dad.openlibrary;

import dad.openlibrary.api.Doc;
import dad.openlibrary.api.OpenLibrary;
import dad.openlibrary.api.SearchResult;
import dad.openlibrary.ui.OpenLibraryApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main {

        public static void main(String[] args) throws IOException {
//            OpenLibrary openLibrary = new OpenLibrary();
//            SearchResult result = openLibrary.getBooks("game of thrones");
//
//            System.out.println("Se han encontrado " + result.getNumFound() + " libros");
//
//            Doc doc = result.getDocs().getFirst();
//
//            System.out.println("--- Primer libro ---");
//            System.out.println("Autor/es: " + doc.getAuthorName());
//            System.out.println("Título: " + doc.getTitle());
//            System.out.println("ISBN: " + doc.getIsbn());
//            System.out.println("Editorial/es: " + doc.getPublisher());
//            System.out.println("Páginas: " + doc.getNumberOfPagesMedian());

            Application.launch(OpenLibraryApp.class, args);
        }
}


