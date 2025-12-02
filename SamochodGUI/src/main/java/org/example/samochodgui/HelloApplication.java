package org.example.samochodgui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // 1. GÓRA (TOP) - Menu i Pasek narzędzi
        VBox topContainer = createTopPanel();
        root.setTop(topContainer);

        // 2. LEWA STRONA (LEFT) - Panele (to już mieliśmy)
        VBox leftPanel = createLeftPanel();
        root.setLeft(leftPanel);

        // 3. ŚRODEK (CENTER) - Obrazek samochodu
        Pane centerPanel = createCenterPanel();
        root.setCenter(centerPanel);

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Symulator Samochodu");
        stage.setScene(scene);
        stage.show();
    }

    // METODA BUDUJĄCA GÓRĘ (MENU + PASEK)
    private VBox createTopPanel() {
        VBox topContainer = new VBox();

        // Pasek Menu (File, Edit)
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("Plik");
        Menu menuEdit = new Menu("Edycja");
        menuBar.getMenus().addAll(menuFile, menuEdit);

        // Pasek narzędzi (ComboBox i przyciski)
        HBox toolBar = new HBox(10);
        toolBar.setPadding(new Insets(10));
        toolBar.setAlignment(Pos.CENTER_LEFT);

        Label labelCar = new Label("Samochód:");
        ComboBox<String> comboCars = new ComboBox<>();
        comboCars.getItems().addAll("Samochód 1", "Samochód 2"); // Przykładowe dane
        comboCars.getSelectionModel().selectFirst();

        Button btnAdd = new Button("Dodaj nowy");
        Button btnRemove = new Button("Usuń");

        toolBar.getChildren().addAll(labelCar, comboCars, btnAdd, btnRemove);

        topContainer.getChildren().addAll(menuBar, toolBar);
        return topContainer;
    }

    //  METODA BUDUJĄCA ŚRODEK (POPRAWIONA POZYCJA)
    private Pane createCenterPanel() {
        Pane centerParams = new Pane(); // Zmiana na Pane (pozwala na współrzędne X,Y)
        centerParams.setStyle("-fx-background-color: lightgreen;");

        try {
            // 1. napis Mapa
            Label mapLabel = new Label("Mapa");
            mapLabel.setLayoutX(10); // 10 pikseli od lewej
            mapLabel.setLayoutY(10); // 10 pikseli od góry

            // 2. Ładujemy obrazek
            Image image = new Image(getClass().getResourceAsStream("/car.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100); // Ustawiamy rozsądną wielkość auta
            imageView.setPreserveRatio(true);

            // 3. Ustawiamy pozycję auta (pod napisem)
            imageView.setLayoutX(10); // 20 px od lewej
            imageView.setLayoutY(40); // 50 px od góry

            centerParams.getChildren().addAll(mapLabel, imageView);
        } catch (Exception e) {
            centerParams.getChildren().add(new Label("Brak obrazka"));
        }

        return centerParams;
    }

    // METODA BUDUJĄCA LEWĄ STRONĘ
    private VBox createLeftPanel() {
        VBox container = new VBox(10);
        container.setPadding(new Insets(10));
        container.setPrefWidth(300);

        // 1. SAMOCHÓD
        GridPane carGrid = new GridPane();
        carGrid.setHgap(5); carGrid.setVgap(5);
        carGrid.add(new Label("Model:"), 0, 0); carGrid.add(new TextField(), 1, 0);
        carGrid.add(new Label("Nr rej:"), 0, 1); carGrid.add(new TextField(), 1, 1);
        carGrid.add(new Label("Waga:"), 0, 2); carGrid.add(new TextField(), 1, 2);
        carGrid.add(new Label("Prędkość:"), 0, 3); carGrid.add(new TextField(), 1, 3);
        carGrid.add(new HBox(5, new Button("Włącz"), new Button("Wyłącz")), 1, 4);
        TitledPane carPane = new TitledPane("Samochód", carGrid);

        // 2. SKRZYNIA BIEGÓW
        GridPane gearGrid = new GridPane();
        gearGrid.setHgap(5); gearGrid.setVgap(5);
        gearGrid.add(new Label("Nazwa:"), 0, 0); gearGrid.add(new TextField(), 1, 0);
        gearGrid.add(new Label("Cena:"), 0, 1); gearGrid.add(new TextField(), 1, 1);
        gearGrid.add(new Label("Waga:"), 0, 2); gearGrid.add(new TextField(), 1, 2);
        gearGrid.add(new Label("Bieg:"), 0, 3); gearGrid.add(new TextField(), 1, 3);
        gearGrid.add(new HBox(5, new Button("Zwiększ bieg"), new Button("Zmniejsz bieg")), 1, 4);
        TitledPane gearPane = new TitledPane("Skrzynia Biegów", gearGrid);
        gearPane.setCollapsible(true);

        // 3. SILNIK
        GridPane engineGrid = new GridPane();
        engineGrid.setHgap(5); engineGrid.setVgap(5);
        engineGrid.add(new Label("Nazwa:"), 0, 0); engineGrid.add(new TextField(), 1, 0);
        engineGrid.add(new Label("Cena:"), 0, 1); engineGrid.add(new TextField(), 1, 1);
        engineGrid.add(new Label("Waga:"), 0, 2); engineGrid.add(new TextField(), 1, 2);
        engineGrid.add(new Label("Obroty:"), 0, 3); engineGrid.add(new TextField(), 1, 3);
        engineGrid.add(new HBox(5, new Button("Dodaj gazu"), new Button("Ujmij gazu")), 1, 4);
        TitledPane enginePane = new TitledPane("Silnik", engineGrid);
        enginePane.setCollapsible(true);

        // 4. SPRZĘGŁO
        GridPane clutchGrid = new GridPane();
        clutchGrid.setHgap(5); clutchGrid.setVgap(5);
        clutchGrid.add(new Label("Nazwa:"), 0, 0); clutchGrid.add(new TextField(), 1, 0);
        clutchGrid.add(new Label("Cena:"), 0, 1); clutchGrid.add(new TextField(), 1, 1);
        clutchGrid.add(new Label("Waga:"), 0, 2); clutchGrid.add(new TextField(), 1, 2);
        clutchGrid.add(new Label("Stan:"), 0, 3); clutchGrid.add(new TextField(), 1, 3);
        clutchGrid.add(new HBox(5, new Button("Naciśnij"), new Button("Zwolnij")), 1, 4);
        TitledPane clutchPane = new TitledPane("Sprzęgło", clutchGrid);
        clutchPane.setCollapsible(true);

        container.getChildren().addAll(carPane, gearPane, enginePane, clutchPane);
        return container;
    }

    public static void main(String[] args) {
        launch();
    }
}