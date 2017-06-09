package com.amazonaws.samples;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		   Parent root = FXMLLoader.load(getClass().getResource("/com/amazonaws/samples/Main.fxml"));
	       Scene scene = new Scene(root);
	       primaryStage.setTitle("SDK 실습");//
	       primaryStage.setScene(scene);//������ â�� ��鼳��
	       primaryStage.show();//������ â �����ֱ�
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
