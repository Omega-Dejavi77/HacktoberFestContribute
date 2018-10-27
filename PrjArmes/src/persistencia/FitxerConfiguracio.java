package persistencia;

import java.io.FileInputStream;
import java.util.Properties;

public class FitxerConfiguracio {

	public static String getFitxer() throws Exception {
		Properties p = new Properties();
		FileInputStream f = new FileInputStream("Eenemic.properties");
		p.load(f);
		f.close();
		return p.getProperty("ShootWar");
	}
}
