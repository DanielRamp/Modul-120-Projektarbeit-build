package application;

import java.util.ArrayList;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class DummyData {

	private static Data data = Data.getInstance();

	public static void dummyData() {
		categories();
		posts();

	}

	public static void categories() {
		if (data.getCategories().isEmpty()) {
			// creating the 5 categories
			data.getCategories().add(new Category(null, "Allgemein", true));
			data.getCategories().add(new Category(null, "Inland", true));
			data.getCategories().add(new Category(null, "Ausland", true));
			data.getCategories().add(new Category(null, "Medizin", true));
			data.getCategories().add(new Category(null, "Technologie", true));
		}
	}

	public static void posts() {
		if (data.getPostList().isEmpty()) {
			// creating ArrayList with Categories of Post 1
			ArrayList<Category> post1Categories = new ArrayList<Category>();
			post1Categories.add(data.getCategories().get(0));
			post1Categories.add(data.getCategories().get(2));

			// creating Post1
			data.addPostList(new Post("icon1", "Titel1", post1Categories, "content1"));

			// creating Post2
			ArrayList<Category> post2Categories = new ArrayList<Category>();
			post2Categories.add(data.getCategories().get(1));
			Data.getInstance().addPostList(new Post("icon2", "Titel2", post2Categories, "content2"));

			// creating Post3
			ArrayList<Category> post3Categories = new ArrayList<Category>();
			post3Categories.add(data.getCategories().get(2));
			Data.getInstance().addPostList(new Post("icon3", "Titel3", post3Categories, "content3"));
		}
	}

}
