package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class View3Controller implements Initializable {
	
	@FXML BorderPane bdpOut, bdpHeader, bdpContent, bdpFooter;
	@FXML GridPane grpMeta;
	
	@FXML private Button btnPrev;
	@FXML private Label lblPost;
	@FXML private Label lblTitel;
	@FXML private TextField txfTitel;
	@FXML private Label lblCategories;
	@FXML private MenuButton mnbCategories;
	@FXML private MenuItem mnbCategoryChooseItem1;
	@FXML private MenuItem mnbCategoryChooseItem2;
	@FXML private TextArea txaContent;
	@FXML private Button btnSendPost;
	
	private Data data = Data.getInstance();
	private Helper helper = Helper.getInstance();
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		mnbCategories.getItems().clear();
		for (Category category : data.getCategories()) {
			CheckBox checkBox = new CheckBox(category.getName());
			Outputter.out(""+data.getCategories().indexOf(category));
			CustomMenuItem customMenuItem = new CustomMenuItem(checkBox);  
			mnbCategories.getItems().add(customMenuItem);
		}
	}

	@FXML public void btnPrevAction() {
		helper.getDialogStage().close();
	}

	@FXML public void btnSendPostAction() {
		
		// creating ArrayList with Categories of Post 1
		ArrayList<Category> categoriesTemp = new ArrayList<Category>();
		/*
		for (int i = 0; i < mnbCategories.getItems().size(); i++) {
			mnbCategories.getItems().get(i)
		}
		*/
		categoriesTemp.add(data.getCategories().get(0));
		categoriesTemp.add(data.getCategories().get(2));
		
		Post post = new Post("asd", txfTitel.getText(), categoriesTemp, txaContent.getText());
		data.getPostList().add(post);
		
		helper.getDialogStage().close();
	}

}
