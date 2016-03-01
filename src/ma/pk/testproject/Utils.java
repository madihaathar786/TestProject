package ma.pk.testproject;

public class Utils {
	public static String getCamelCase(String str) {
		return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1);

	}

	public static PersonDTO parseName(String str) {

		if (str.contains(",")) {
			String[] ss = str.split(",");
			return new PersonDTO(Utils.getCamelCase(ss[0].trim()), Utils.getCamelCase(ss[1].trim()));
		}
		return new PersonDTO(Utils.getCamelCase(str));

	}
}
