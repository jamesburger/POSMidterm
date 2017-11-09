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

		Path writeFile = Paths.get(folder, fileName);
		File inventoryFile = writeFile.toFile();

		try {
			FileReader fr = new FileReader(inventoryFile);
			// this is a buffer and the benefit of using this is to store a block of memory
			// that we can read data from later
			// -- more efficient than Scanner and it will not cause errors
			BufferedReader reader = new BufferedReader(fr);
			// this is attempting to read the first line from the text docu
			String line = reader.readLine();

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
		return menuCreated;
	}

	public static void writeProduct(Scanner scannerName, String folderName, String file) {
		Path writeFile = Paths.get(folderName, file);
		File fileName = writeFile.toFile();

		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(fileName, true));
			out.println(Validator.getString(scannerName, "Enter a Product: <Product name>, <Category>, <Description>, <Price>, <Inventory>\n"));
			out.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			writeProduct(scan,"ProductLists", "inventory.txt");
		for (Product line : createMenu("ProductLists", "inventory.txt")) {
			System.out.println(line);
		}
	}
}
