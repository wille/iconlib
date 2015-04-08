package iconlib;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

public class FileIconUtils {
	
	/**
	 * Cache of file icons
	 */
	private static final Map<String, Icon> CACHE = new HashMap<String, Icon>();
	
	/**
	 * Gets icon for specific file
	 * @param file
	 * @return
	 */
	public static Icon getIconFromFile(File file) {
		return FileSystemView.getFileSystemView().getSystemIcon(file);
	}	
	
	/**
	 * Gets system default folder icon
	 * @return
	 */
	public static Icon getFolderIcon() {
		Icon icon;
		
		if (CACHE.containsKey("file-dir")) {
			icon = CACHE.get("file-dir");
		} else {
			File temp = new File(System.getProperty("java.io.tmpdir") + File.separator + "icon");
			temp.mkdirs();
			
			icon = FileSystemView.getFileSystemView().getSystemIcon(temp);
			
			CACHE.put("file-dir", icon);
			
			temp.delete();
		}			
		
		return icon;
	}
	
	public static Icon getIconFromExtension(String f, boolean folder) {
		if (folder) {
			return getFolderIcon();
		} else {
			return getIconFromExtension(f);
		}
	}

	/**
	 * Gets default icon from file extension
	 * @param f String like test.png
	 * @return
	 */
	public static Icon getIconFromExtension(String f) {
		String extension;
		
		if (f.contains(".")) {
			extension = f.substring(f.lastIndexOf("."), f.length());
		} else {
			extension = "";
		}
		
		Icon icon = null;
		
		if (CACHE.containsKey(extension)) {
			icon = CACHE.get(extension);
		} else {
			try {
				File temp = File.createTempFile((new Random()).nextInt() + "", extension);
				icon = FileSystemView.getFileSystemView().getSystemIcon(temp);
				
				CACHE.put(extension, icon);
				
				temp.delete();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return icon;
	}
}
