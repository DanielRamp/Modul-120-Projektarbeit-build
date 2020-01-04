package application;

import java.time.Instant;
import java.util.ArrayList;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class Post {

	private String icon;
	private String title;
	private ArrayList<Category> categories = new ArrayList<Category>();
	private String content;
	private Boolean isRead;
	private Instant createdAt;
	
	/**
	 * @param icon
	 * @param title
	 * @param categories
	 * @param content
	 * @param isRead
	 * @param createdAt
	 */
	public Post(String icon, String title, ArrayList<Category> categories, String content) {
		this.icon = icon;
		this.title = title;
		this.categories = categories;
		this.content = content;
		this.isRead = false;
		this.createdAt = Instant.now();
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the isRead
	 */
	public Boolean getIsRead() {
		return isRead;
	}

	/**
	 * @param isRead the isRead to set
	 */
	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	/**
	 * @return the createdAt
	 */
	public Instant getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
}
