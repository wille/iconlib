package iconlib;

import java.net.URL;
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
		return getIcon(path, true, null);
	}
	
	public static ImageIcon getIcon(String path, Class<?> clazz) {
		return getIcon(path, true, clazz);
	}
	
	public static ImageIcon getIcon(String path, boolean defaultPath) {
		return getIcon(path, defaultPath, null);
	}
	
	/**
	 * Returns icon from path (
	 * @param path
	 * @param defaultPath If should return icon with default extension and in default path
	 * @return the icon
	 */
	public static ImageIcon getIcon(String path, boolean defaultPath, Class<?> clazz) {
		if (defaultPath) {
			path = "/icons/" + path + ".png";
		}
		
		if (clazz == null) {
			clazz = IconUtils.class;
		}
		
		ImageIcon icon;
		
		if (CACHE.containsKey(path)) {
			icon = CACHE.get(path);
		} else {
			URL url = clazz.getResource(path);

			if (url == null) {
				return null;
			}
			
			icon = new ImageIcon(url);
			CACHE.put(path, icon);
		}
		
		return icon;
	}

}
