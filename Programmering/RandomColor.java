package lab.random;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
 
import java.util.Random;
 
/**
*It is a javafx application to draw a circle.
*The circle will be filled with a different color at every launch.
*/
public class RandomColor extends Application {
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override    
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        stage.setMaxHeight(350);
        stage.setMaxWidth(350);
        stage.setResizable(false);
        Scene scene = new Scene(root, stage.getMaxWidth(), stage.getMaxHeight());
        stage.setScene(scene);
        Circle circle = createCircle();
        circle.setFill(RandomColour());
        root.setCenter(circle);
        stage.show();
    }
/**
Creates a circle
*/
    private Circle createCircle() {
        Circle circle = new Circle(150);
        return circle;
    }
/**
Create random color every time the method is called.
*/
    public Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }
}