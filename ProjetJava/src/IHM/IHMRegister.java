package IHM;

import DAO.PersonDAO;
import application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import oo.Crypt;
import oo.Person;
import oo.Restaurant;

public class IHMRegister implements EventHandler<ActionEvent> {

	// Variables à utiliser par plusieurs méthodes de la classe
	Stage stageRegister;
	Hyperlink link;
	TextField name,adresse,phone;
	PasswordField rpPassword,password;
	Button btnRegister;
	
	//Constructeur qui va faire la conception de l'interface d'ajout d'une formation
	public IHMRegister() {
		stageRegister = new Stage();
		stageRegister.setTitle("Register");
		stageRegister.addEventHandler(ActionEvent.ACTION,this);
	
		
		VBox  root = new VBox(10);
		

		Label title=new Label("Register");
		title.setStyle(" -fx-text-fill: white;");

		
		title.setFont(Font.font("System",FontWeight.EXTRA_BOLD,30));
		
//		----------Form---------------
		VBox Form = new VBox(10);
		
		VBox namee=new VBox(10);
		Label nm=new Label("UserName :");
		nm.setFont(Font.font("System",FontWeight.BOLD,13));
		nm.setStyle(" -fx-text-fill: white;");
		name = new TextField();
		namee.getChildren().addAll(nm,name);
		
		VBox adressee=new VBox(10);
		Label adr=new Label("Adresse :");
		adr.setStyle(" -fx-text-fill: white;");
		adr.setFont(Font.font("System",FontWeight.BOLD,13));
		 adresse = new TextField();
		namee.getChildren().addAll(adr,adresse);
		
		VBox phonee=new VBox(10);
		Label ph=new Label("Phone :");
		ph.setStyle(" -fx-text-fill: white;");
		ph.setFont(Font.font("System",FontWeight.BOLD,13));
		 phone = new TextField();
		namee.getChildren().addAll(ph,phone);
		
		VBox passe=new VBox(10);
		Label ps=new Label("Password :");
		ps.setStyle(" -fx-text-fill: white;");
		ps.setFont(Font.font("System",FontWeight.BOLD,13));
		 password = new PasswordField();
		passe.getChildren().addAll(ps,password);
		VBox rpPasse=new VBox(10);
		Label rpPs=new Label("Repeat Password :");
		rpPs.setStyle(" -fx-text-fill: white;");
		rpPs.setFont(Font.font("System",FontWeight.BOLD,13));
		 rpPassword = new PasswordField();
		passe.getChildren().addAll(rpPs,rpPassword);
		

		 btnRegister=new Button("Register");
		btnRegister.setOnMouseEntered(e -> btnRegister.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-padding: 0.333333em 0.666667em 0.333333em 0.666667em;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
		btnRegister.setOnMouseExited(e -> btnRegister.setStyle("-fx-background-color:white;"));
		btnRegister.addEventHandler(ActionEvent.ACTION,this);

		link = new Hyperlink();
		link.setText("Try To Login !");
		link.setStyle("-fx-text-fill:#05F29B;");
		link.addEventHandler(ActionEvent.ACTION,this);


		Form.setPadding(new Insets(20, 350, 20, 350));
		Form.setAlignment(Pos.CENTER);
		Form.getChildren().addAll(namee,adressee,passe,rpPasse,btnRegister ,link);
		root.getChildren().addAll(title,Form);
		root.setAlignment(Pos.CENTER);
		
    root.setStyle("-fx-background-image:url('roadmap.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1000 800; -fx-background-position: center center;");
	

		// params de la fenete
		Scene sceneRegister = new Scene(root,1000,600);
		stageRegister.setScene(sceneRegister);
		stageRegister.show();
		
	}
	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		 Alert a1=new Alert(Alert.AlertType.WARNING);
         a1.setTitle("Success !");
		if (source == link) {
			Main login = new Main();
			login.start(stageRegister);
			
		}else if (source==btnRegister) {
		
			if(name.getText()!=""&&adresse.getText()!=""&&phone.getText()!=""&&password.getText()!=""&&rpPassword.getText()!=""&&phone.getText().length()==8) {
				if(rpPassword.getText().equals(password.getText())) {
					Person p=PersonDAO.RechercherParEmail(adresse.getText());
					if(p==null) {
						Crypt td = null;
						try {
							td = new Crypt();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				        String target=password.getText();
				        String encrypted=td.encrypt(target);
				        
						Person person = new Person("1", name.getText(),adresse.getText(),phone.getText(),encrypted);
						Person p1=PersonDAO.Ajouter(person);
					if(p1!=null) {
						 a1.setHeaderText("Your Account has been created !!");
		                 a1.showAndWait();
						Main login = new Main();
						login.start(stageRegister);
					}
					
					
						
					}else {
						a1.setHeaderText("Email exist !!");
		                 a1.showAndWait();
					}
					
					
				}else {
					a1.setHeaderText("Invalid Repeat password!!");
	                 a1.showAndWait();
				}
				
				
				
			}else {
				 a1.setHeaderText("Please Fill The Form !!");
                 a1.showAndWait();
			}
			
		}
		
	}

}
