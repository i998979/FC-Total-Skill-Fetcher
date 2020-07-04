import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlexingChimps {
	
	public static String[] members = {
		"alex1axel",
		"Knattekalle",
		"Radicial",
		"BigHero6",
		"JollyAndrew",
		"Spalter90DayMute",
		"TehManu",
		"Aimaar",
		"RQuit",
		"GutterGT",
		"LowLightning",
		"SophiaHunt2003",
		"Telecoms",
		"Oyasumi",
		"Broshen",
		"Thokan",
		"FakeSchoolBus",
		"Awesomah",
		"Flemmsen",
		"8_L",
		"TQzer",
		"Lumb1234",
		"YT_OS_Broke",
		"Prince_Luca_IV",
		"SuperVladimir",
		"Galaxian_Blade",
		"GoodLuckPlease",
		"ChayUwU",
		"pepsi6",
		"100KPureHandsome",
		"iM_sXon",
		"trytoclean",
		"vincent89100",
		"Haardzz",
		"Impxssible",
		"ckac10",
		"Abrasive_",
		"Dominix7",
		"t0m1893",
		"MayorTF",
		"_Okto",
		"iAngeloVz",
		"droperdd",
		"Starvo1ce",
		"LuhniHD",
		"KatzeTF",
		"Thamix",
		"Pagety",
		"max_rawr",
		"GameurTheTacos",
		"Fanzo07",
		"QuendolinHD",
		"GotKiller_",
		"Ragei",
		"xHadytx",
		"LulCheesecake",
		"Criteox",
		"Scr1",
		"josiiiii_",
		"Jwaffled",
		"OliverThrane123",
		"Worthiy",
		"Valis",
		"MiunaSayu",
		"Arvality",
		"pennbroder",
		"SirWipely",
		"_Sanchester",
		"WINNER_7y",
		"Rayoh",
		"Chpun",
		"ThePVP_IL",
		"Gecy",
		"JustenGHG",
		"Spaghettiis",
		"NeverForgotten",
		"kissen",
		"YellowStriker",
		"MegaGameF",
		"EzStrafez",
		"huhw",
		"Jchad",
		"uwuKori",
		"MasterJ007",
		"Pyroxenic",
		"Feega",
		"Lostelle",
		"NebulaX59",
		"jacckt23",
		"jerrygirl",
		"LegendUwU",
		"Tecthiq_",
		"Designful",
		"unconditioned",
		"GuiGuilson",
		"hiruke",
		"nonished",
		"Gurlh",
		"Garfield2001",
		"dzcole",
		"Wehboh",
		"Furball",
		"Masskill",
		"DopeDox",
		"we4",
		"BunnyJr",
		"PyrosChild",
		"Morizzaa",
		"GalaxyMonkeyy",
		"aless1",
		"hqmzah",
		"Lowstars",
		"Diego6z",
		"weirdhappy",
		"xBild"
	};
	
	public static HashMap<String, Long> exps = new HashMap<>();

	public static void main(String[] args) {
		
		String st = "";
		
		File file = new File("1.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				System.out.println(st);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// members = st.split("\n");
		
		

		for (String member: members) {
			System.out.println("Checking " + member);
			
			/* * * * * * * * * *
			 * Profile
			 * * * * * * * * * */
			try {
				URL url = new URL("https://sky.lea.moe/api/" + member + "/profiles?html");
				URLConnection con = url.openConnection();
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				InputStream in = con.getInputStream();
				String encoding = con.getContentEncoding();
				encoding = encoding == null ? "UTF-8" : encoding;
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[8192];
				int len = 0;
				while ((len = in .read(buf)) != -1) {
					baos.write(buf, 0, len);
				}
				
				// HTML -> Table
				String body = new String(baos.toByteArray(), encoding);
				body = body.replace("</tr>", "\n");
				body = body.replace("</td>", "\t");
				String str = body.replaceAll("\\<.*?\\>", "");
				
				// Split out the profile names
				String[] lines0 = str.split("\n");
				List<String> profiles = new ArrayList<>();
				for (String string: lines0) {
					String profile = string.split("\t")[1];
					profiles.add(profile);
				}
				
				
				
				/* * * * * * * * * *
				 * Exp fetcher
				 * * * * * * * * * */
				List<Long> profileExp = new ArrayList<>();
				
				for (int i = 0; i < profiles.size(); i++) {
					URL url0 = new URL("https://sky.lea.moe/api/" + member + "/" + profiles.get(i) + "/skills?html&progress");
					URLConnection con0 = url0.openConnection();
					con0.setRequestProperty("User-Agent", "Mozilla/5.0");
					InputStream in0 = con0.getInputStream();
					String encoding0 = con0.getContentEncoding();
					encoding0 = encoding0 == null ? "UTF-8" : encoding0;
					
					ByteArrayOutputStream baos0 = new ByteArrayOutputStream();
					byte[] buf0 = new byte[8192];
					int len0 = 0;
					while ((len0 = in0.read(buf0)) != -1) {
						baos0.write(buf0, 0, len0);
					}
					
					// HTML -> Table
					String body0 = new String(baos0.toByteArray(), encoding0);
					body0 = body0.replace("</tr>", "\n");
					body0 = body0.replace("</td>", "\t");
					String str0 = body0.replaceAll("\\<.*?\\>", "");
					try {
						str0 = str0.substring(0, str0.indexOf("Carpentry"));
					} catch (Exception e) {
						// TODO - RuneCrafting
						str0 = str0.substring(0, str0.indexOf("Zombie"));
					}
					
					// Split out the skill exp
					String[] lines1 = str0.split("\n");
					List < String > skills = new ArrayList < > ();
					for (String string: lines1) {
						String skill = string.split("\t")[3];
						skills.add(skill);
					}
					
					// TODO - Decimal places ignored causes data loss
					long total = 0;
					for (String line : skills) {
						if (line.indexOf(".") != -1) {
							String line0 = line.substring(0, line.indexOf("."));
							total += Long.parseLong(line0);
						}
						else {
							try {
								total += Long.parseLong(line);
							} catch (Exception e) {}
						}
					}
					
					profileExp.add(total);
				}
				
				
				
				/* * * * * * * * * *
				 * Get largest profile's exp
				 * * * * * * * * * */
				long largest = 0;
				for (long exp: profileExp) {
					if (exp > largest) largest = exp;
				}
				
				exps.put(member, largest);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for (Map.Entry<String, Long> entry : exps.entrySet()) {
			String name = entry.getKey();
			long exp = entry.getValue();
			System.out.println(name + ": " + exp);
		}
	}
}