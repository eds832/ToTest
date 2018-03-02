import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Folders {
	public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
		Collection<String> names = new ArrayList<>();
		String regexp = "name=[\"]" + new Character(startingLetter).toString() + "[^\"]*";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(xml);
		while (matcher.find()) {
			names.add(matcher.group().substring(6));
		}
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource src = new InputSource();
		src.setCharacterStream(new StringReader(xml));
		Document doc = builder.parse(src);
		List<String> listObj = new ArrayList<String>();
		if (doc.getElementsByTagName("folder").item(0) != null) {
			for (int i = 0; doc.getElementsByTagName("folder").getLength() > i; i++) {
				String item = doc.getElementsByTagName("folder").item(i).getAttributes().getNamedItem("name")
						.getNodeValue();
				if (item.startsWith(new Character(startingLetter).toString())) {
					listObj.add(item);
				}
			}
		}
		return listObj;
		// throw new UnsupportedOperationException("Waiting to be implemented.");
	}

	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<folder name=\"c\">"
				+ "<folder name=\"program files\">" + "<folder name=\"uninstall information\" />" + "</folder>"
				+ "<folder name=\"users\" />" + "</folder>";

		Collection<String> names = folderNames(xml, 'u');
		for (String name : names)
		System.out.println(name);
	}
}