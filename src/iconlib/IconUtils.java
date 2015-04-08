package iconlib;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class IconUtils {
	
	/**
	 * Cache of icons
	 */
	private static final Map<String, ImageIcon> CACHE = new HashMap<String, ImageIcon>();

	/**
	 * Gets icon from default path (/icons/name.png)
	 * @param path
	 * @return the icon
	 */
	public static ImageIcon getIcon(String path) {
		return getIcon(path, true);
	}
	
	/**
	 * Returns icon from path (
	 * @param path
	 * @param defaultPath If should return icon with default extension and in default path
	 * @return the icon
	 */
	public static ImageIcon getIcon(String path, boolean defaultPath) {
		if (defaultPath) {
			path = "/icons/" + path + ".png";
		}
		
		ImageIcon icon;
		
		if (CACHE.containsKey(path)) {
			icon = CACHE.get(path);
		} else {
			icon = new ImageIcon(IconUtils.class.getResource(path));
			CACHE.put(path, icon);
		}
		
		return icon;
	}

}
