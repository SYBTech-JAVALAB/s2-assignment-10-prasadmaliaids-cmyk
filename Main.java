import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) {

        TextField num1 = new TextField();
        TextField num2 = new TextField();
        TextField result = new TextField();
        result.setEditable(false);

        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");

        // Event Handling
        add.setOnAction(e -> {
            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());
            result.setText(String.valueOf(a + b));
        });

        sub.setOnAction(e -> {
            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());
            result.setText(String.valueOf(a - b));
        });

        mul.setOnAction(e -> {
            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());
            result.setText(String.valueOf(a * b));
        });

        div.setOnAction(e -> {
            try {
                int a = Integer.parseInt(num1.getText());
                int b = Integer.parseInt(num2.getText());
                result.setText(String.valueOf(a / b));
            } catch (ArithmeticException ex) {
                result.setText("Cannot divide by zero");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("Number 1"), 0, 0);
        grid.add(num1, 1, 0);

        grid.add(new Label("Number 2"), 0, 1);
        grid.add(num2, 1, 1);

        grid.add(add, 0, 2);
        grid.add(sub, 1, 2);
        grid.add(mul, 0, 3);
        grid.add(div, 1, 3);

        grid.add(new Label("Result"), 0, 4);
        grid.add(result, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("Simple Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}