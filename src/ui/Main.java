package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application {
	
	private Classroom classroom;
	private ClassroomGUI classroomgui;
	
	public Main() {
		classroom = new Classroom();
		classroomgui = new ClassroomGUI(classroom);
	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("main-pain.fxml"));	
       loader.setController(classroomgui);
       
       Parent root= loader.load();
       Scene scene= new Scene(root);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Classroom");
       primaryStage.show();
       }

}
