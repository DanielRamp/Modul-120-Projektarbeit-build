package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class Helper {
	
	private static Helper instance;
	
	// CONSTANTS
	private static final int STAGEMINHEIGHT = 400;
	private static final int STAGEMINWIDTH = 600;
	
	private Stage stage, dialogStage; // Swing: JFrame
	private Scene scene, dialogScene; // Swing: content pane
	private Parent root, dialogRoot;
	
	public static Helper getInstance () {
	    if (Helper.instance == null) {
	    	Helper.instance = new Helper ();
	    }
	    return Helper.instance;
	}
	
	
	public void firstView(Stage stage, String view) {
		
		root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(view));
		} catch (IOException e) {
			Outputter.err(e.getStackTrace().toString());
		}
		
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		
		
		// Title and Icon
		stage.setTitle("News");
		try {
			Image icon = new Image(getClass().getResourceAsStream("img/newspaper.png"));
			stage.getIcons().add(icon);
		} catch (Exception e) {
			Outputter.err(e.getStackTrace().toString());
		}
		
		// minimal Dimensions
		stage.setMinHeight(STAGEMINHEIGHT);
		stage.setMinHeight(STAGEMINWIDTH);
	}
	
	public void changeView(Button btn, String view) {
		root = null;
		
		try {
			root = FXMLLoader.load(getClass().getResource(view));
		} catch (IOException e) {
			Outputter.err(e.getStackTrace().toString());
		}
		
		scene.setRoot(root);
	}
	
	public FXMLLoader changeViewLoader(Button btn, String view) {
		FXMLLoader load;
		
		stage = (Stage) btn.getScene().getWindow();
		
		load = new FXMLLoader(getClass().getResource(view));
		
		try {
			root = (Parent) load.load();
		} catch (IOException e) {
			Outputter.err(e.getStackTrace().toString());
		}
		
		scene.setRoot(root);
		
		return load;
	}
	
	public void dialogView(Button btn, String view) {
		dialogStage = new Stage();
		
		dialogRoot = null;
		try {
			dialogRoot = FXMLLoader.load(getClass().getResource(view));
		} catch (IOException e) {
			Outputter.err(e.getStackTrace().toString());
		}
		
		dialogScene = new Scene(dialogRoot);
		dialogStage.setScene(dialogScene);
		
		dialogStage.initOwner(stage);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.showAndWait();
	}


	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @return the dialogStage
	 */
	public Stage getDialogStage() {
		return dialogStage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
