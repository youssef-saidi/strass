package IHM;

import DAO.ConnexionBD;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import oo.Person;
import oo.Restaurant;

public class IHMMain implements EventHandler<ActionEvent>{
	Stage stageMain;
	Button AjRest,SeRest,Quitter,Retour;
	
	public IHMMain()  {
		stageMain = new Stage();
		stageMain.setTitle("Admin");
		stageMain.addEventHandler(ActionEvent.ACTION,this);
		VBox root=new VBox(100);
		Label tMain=new Label("Welcome !");
		
		tMain.setStyle(" -fx-text-fill: white;");
		tMain.setFont(Font.font("System",FontWeight.BOLD,40));
		
		HBox hb = new HBox(60);
		AjRest = new Button("Ajouter un Rest");
		AjRest.setPadding(new Insets(10, 20, 10, 20));
		AjRest.setOnMouseEntered(e -> AjRest.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
		AjRest.setOnMouseExited(e -> AjRest.setStyle("-fx-background-color:white;"));
		AjRest.addEventHandler(ActionEvent.ACTION,this);
		SeRest = new Button("Cherhcer Rest");
		SeRest.setPadding(new Insets(10, 20, 10, 20));
		SeRest.setOnMouseEntered(e -> SeRest.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
		SeRest.setOnMouseExited(e -> SeRest.setStyle("-fx-background-color:white;"));
		SeRest.minWidth(500);
		SeRest.addEventHandler(ActionEvent.ACTION,this);
		hb.getChildren().addAll(AjRest,SeRest);
		hb.setAlignment(Pos.CENTER);
		 Retour=new Button("Retour");
		 Retour.addEventHandler(ActionEvent.ACTION,this);
		 Quitter=new Button("Quitter");
		 Quitter.addEventHandler(ActionEvent.ACTION,this);
		 Retour.setOnMouseEntered(e -> Retour.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
		 Retour.setOnMouseExited(e -> Retour.setStyle("-fx-background-color:white;"));
		 Quitter.setOnMouseEntered(e -> Quitter.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
		 Quitter.setOnMouseExited(e -> Quitter.setStyle("-fx-background-color:white;"));
		 
		HBox hbt=new HBox(10);
		
		hbt.setAlignment(Pos.CENTER);
		hbt.getChildren().addAll(Retour,Quitter);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(tMain,hb,hbt);
		 root.setStyle("-fx-background-image:url('roadmap.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1000 800; -fx-background-position: center center;");
	
		 

		// params de la fenete
		Scene sceneMain = new Scene(root,1000,600);
		stageMain.setScene(sceneMain);
		stageMain.show();
	}
		
		


	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source==AjRest) {
			IHMRest fRest = new IHMRest();
			stageMain.close();
		}else if(source==SeRest) {
			IHMUser fUser = new IHMUser();
			stageMain.close();
			
		}else if(source==Retour) {
			IHMMain fUser = new IHMMain();
			stageMain.close();
			
		}else if(source==Quitter) {
			ConnexionBD.Fermer();
			stageMain.close();
			
		}
		
	}

}
