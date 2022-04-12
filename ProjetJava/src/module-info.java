module ProjetJava {

		requires javafx.controls;
		requires javafx.web;
		requires java.sql;
		
		opens application to javafx.graphics, javafx.fxml,javafx.base;
		opens IHM to javafx.graphics, javafx.fxml,javafx.base;
		opens oo to javafx.graphics, javafx.fxml,javafx.base;
	}

