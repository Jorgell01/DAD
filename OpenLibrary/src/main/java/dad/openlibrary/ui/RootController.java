package dad.openlibrary.ui;

import dad.openlibrary.api.Doc;
import dad.openlibrary.api.OpenLibrary;
import dad.openlibrary.api.SearchResult;
import dad.openlibrary.model.Book;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RootController implements Initializable {

    // logic

    private OpenLibrary openLibrary = new OpenLibrary();

    //model

    private StringProperty search = new SimpleStringProperty();
    private ListProperty<Book> books = new SimpleListProperty<>(FXCollections.observableArrayList());

    //view

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableView<Book> booksTable;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, Number> pagesColumn;

    @FXML
    private TableColumn<Book, String> publisherColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, Boolean> hasPagesColumn;

    @FXML
    private BorderPane root;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchText;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //cell value factories

        titleColumn.setCellValueFactory(v -> v.getValue().titleProperty());
        authorColumn.setCellValueFactory(v -> v.getValue().authorProperty());
        isbnColumn.setCellValueFactory(v -> v.getValue().isbnProperty());
        publisherColumn.setCellValueFactory(v -> v.getValue().publisherProperty());
        pagesColumn.setCellValueFactory(v -> v.getValue().numPagesProperty());
        hasPagesColumn.setCellValueFactory(v -> v.getValue().hasPagesProperty());

        // cell factories

        hasPagesColumn.setCellFactory(CheckBoxTableCell.forTableColumn(hasPagesColumn));

        //bindings

        booksTable.itemsProperty().bind(books);
        search.bind(searchText.textProperty());
    }

    public static BorderPane getRoot() {
        return new RootController().root;
    }

    @FXML
    void onSearchAction(ActionEvent event) {

        try {
            SearchResult result = openLibrary.getBooks(search.get());
            List<Book> books = result.getDocs()
                    .stream()
                    .map(Book::new)
//                    .filter(book -> book.getNumPages() != 0)
                    .toList();
            this.books.setAll(books);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(root.getScene().getWindow());
            alert.setTitle("Error");
            alert.setHeaderText("Error al buscar libros");
            alert.setContentText(e.getLocalizedMessage());
            alert.showAndWait();
            throw new RuntimeException(e);
        }

    }

}