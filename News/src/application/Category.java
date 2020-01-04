package application;

/**
 * @author daniel<daniel.ramp@gibmit.ch>
 *
 */
public class Category {

	private String icon;
	private String name;
	private Boolean selected;

	/**
	 * @param icon
	 * @param name
	 * @param selected
	 */
	public Category(String icon, String name, Boolean selected) {
		this.icon = icon;
		this.name = name;
		this.selected = selected;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return true if selected, else false
	 */
	public Boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
