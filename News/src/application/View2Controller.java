package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class View2Controller implements Initializable {
	
	@FXML Label lblFeed;
	@FXML Button btnPrev;
	@FXML Button btnRefresh;
	@FXML Button btnClearPosts;
	@FXML Button btnNewPost;
	@FXML ListView<String> lstPosts;
	
	Data data = Data.getInstance();
	Helper helper = Helper.getInstance();
	
	final ObservableList<String> listItems = FXCollections.observableArrayList("Add Items here");
	
	

	public void initialize(URL arg0, ResourceBundle arg1) {
		lstPosts.setItems(listItems);
		DummyData.dummyData();
		refreshlstPosts();
	}

	public void refreshlstPosts() {
		listItems.clear();
		for (Post post : data.getPostList()) {
			if (!post.getIsRead()) {
				StringBuilder categoriesStringBuilder = new StringBuilder();
				Boolean isSelected = false;
				for (Category postCategories : post.getCategories()) {
					if (postCategories.isSelected()) {
						isSelected = true;
					}
					if (categoriesStringBuilder.toString().isEmpty()) {
						categoriesStringBuilder.append(postCategories.getName());
					} else {
						categoriesStringBuilder.append(", "+postCategories.getName());
					}
				}
				if (isSelected) {
					listItems.add("Kategorie(n): "+categoriesStringBuilder.toString()+"\nTitel: "+post.getTitle()+"\nInhalt: "+post.getContent()+"");
				}
				
			}
		}
	}
	
	
	@FXML public void btnPrevAction() {
		FXMLLoader load = helper.changeViewLoader(btnPrev, "View1.fxml");
		
		// hide lblWelcome on View1 - to recycle View1
		View1Controller view1Controller = load.getController();
		view1Controller.hideWelcome();
	}
	
	

	@FXML public void btnRefreshAction() {
		refreshlstPosts();
	}
	
	

	@FXML public void btnClearPostsAction() {
		for (Post post : data.getPostList()) {
			post.setIsRead(true);
		}
		refreshlstPosts();
	}

	

	@FXML public void btnNewPostAction() {
		helper.dialogView(btnPrev, "View3.fxml");
	}

}
