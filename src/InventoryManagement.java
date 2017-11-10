import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {

	public static ArrayList<Product> createMenu(String folderName, String file) {
		String folder = folderName;
		String fileName = file;
		String parsedLine = "";
		ArrayList<Product> menuCreated = new ArrayList<Product>();

		// identify path
		Path writeFile = Paths.get(folder, fileName);
		File inventoryFile = writeFile.toFile();

		try {

			// init reader
			FileReader fr = new FileReader(inventoryFile);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			// comb inventory and parse Product fields
			while (line != null) {
				parsedLine = line.toString();
				String[] productFields = parsedLine.split(", ");
				menuCreated.add(new Product(productFields[0], productFields[1], productFields[2],
						Double.parseDouble(productFields[3]), Integer.parseInt(productFields[4])));
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("I can't read!");
			e.printStackTrace();
		}

		// sort inventory in menu ArrayList
		menuCreated.sort(new ProductCamparator());
		return menuCreated;
	}

	public static void writeProduct(Scanner scannerName, String folderName, String file) {

		// identify path
		Path writeFile = Paths.get(folderName, file);
		File fileName = writeFile.toFile();

		try {

			// init writer
			PrintWriter out = new PrintWriter(new FileOutputStream(fileName, true));

			// accept formatted inventory addition
			out.println(Validator.getString(scannerName,
					"Enter a Product: <Product name>, <Category>, <Description>, <Price>, <Inventory>\n"));
			out.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
