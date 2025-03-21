package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import services.CalculationService;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		
		String path = "c:\\temp\\in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				String[] separe = line.split(",");
			
				list.add(new Product(separe[0], Double.parseDouble(separe[1])));
				line = br.readLine();
			}
			
			Product x = CalculationService.max(list);   
			System.out.println("Most expensive product: ");
			System.out.println(x);
		}
		catch(IOException e) {
			System.out.println("Input Error: " + e.getMessage());
		}
	}

}
