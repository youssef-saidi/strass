package application;


import java.sql.Connection;

import DAO.ConnexionBD;
import DAO.PersonDAO;
import IHM.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import oo.Crypt;
import oo.Person;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main  extends Application implements EventHandler<ActionEvent> {
	Button btnLogin;
	Hyperlink linkRegister;
	Stage primaryStage;
	TextField email;
	PasswordField password;
	@Override
	public void start(Stage primaryStage) {

		VBox  root = new VBox(10);
			
			Scene scene = new Scene(root,1000,600);
		try {
		
		
		
			Label title=new Label("Login");
			title.getStyleClass().add("title");
			
			title.setFont(Font.font("System",FontWeight.EXTRA_BOLD,30));
			
//			----------Form---------------
			VBox Form = new VBox(10);
			
			VBox namee=new VBox(10);
			Label nm=new Label("Email :");
			nm.getStyleClass().add("title");
			nm.setFont(Font.font("System",FontWeight.BOLD,13));
			email = new TextField();
			namee.getChildren().addAll(nm,email);
			VBox passe=new VBox(10);
			Label ps=new Label("Password :");
			ps.getStyleClass().add("title");
			ps.setFont(Font.font("System",FontWeight.BOLD,13));
			 password = new PasswordField();
			passe.getChildren().addAll(ps,password);

			 btnLogin=new Button("Login");
			btnLogin.addEventHandler(ActionEvent.ACTION,this);
			
			
			
			btnLogin.getStyleClass().add("button");
			linkRegister = new Hyperlink();
			linkRegister.setText("Try To Register !");
			linkRegister.getStyleClass().add("link");
			linkRegister.addEventHandler(ActionEvent.ACTION,this);

			
			
			Form.setPadding(new Insets(20, 350, 20, 350));
			Form.setAlignment(Pos.CENTER);
			Form.getChildren().addAll(namee,passe,btnLogin ,linkRegister);
			
//			-----------------------------------
			
			root.getChildren().addAll(title,Form);
			root.setAlignment(Pos.CENTER);
			
			
//		    root.setStyle("-fx-background-image:url('roadmap.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1000 800; -fx-background-position: center center;");
			Image img = new Image("roadmap.jpg");
	        BackgroundImage bImg = new BackgroundImage(img,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.CENTER,
	                new BackgroundSize(1000,800,false,false,false,false));
	        Background bGround = new Background(bImg);
	        root.setBackground(bGround);
		    primaryStage.setScene(scene);
			primaryStage.show();
			this.primaryStage=primaryStage;
			scene.getStylesheets().addAll(getClass().getResource("application.css").toExternalForm());

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		   Alert a1=new Alert(Alert.AlertType.WARNING);
           a1.setTitle("Error !");
		if (source == linkRegister) {
			IHMRegister fRegister = new IHMRegister();
			primaryStage.close();	
		}else 	if (source == btnLogin) {
			if(email.getText().equals("admin@gmail.com")&&password.getText().equals("admin")) {
				IHMAdmin fUser = new IHMAdmin();
				primaryStage.close();	
				
			}else  if(password.getText()!=""&&email.getText()!="") {
					Crypt td = null;
					try {
						td = new Crypt();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			        
		
					Person p=PersonDAO.RechercherParEmail(email.getText());
				if(p!=null) {
					
					String decrypted=td.decrypt(p.getPassword());
					System.out.println(decrypted);

					if(decrypted.equals(password.getText())) {
						System.out.println("Login !!");
						IHMMain fRest = new IHMMain();
						primaryStage.close();
					}else {
						 a1.setHeaderText("Invalid Password !");
		                 a1.showAndWait();
					}
					
					
				}else {
					 a1.setHeaderText("Invalid Email !");
	                 a1.showAndWait();
				}
					
				
				
	
			}else {
				 a1.setHeaderText("Please Fill The Form !!");
                 a1.showAndWait();
			}
		}
		
		
	}

	
}
