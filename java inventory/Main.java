import java.util.*;
import java.io.*;

public class Main {

    // Our list of products + file name
    static ArrayList<Product> list = new ArrayList<>();
    static String FILE = "inventory.dat";

    public static void main(String[] args) throws Exception {
        loadFile(); // Load saved data on startup
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Show menu
            System.out.println("\n1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Search by ID");
            System.out.println("4. Total Stock Value");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("ID: ");      int id  = sc.nextInt();  sc.nextLine();
                System.out.print("Name: ");    String name = sc.nextLine();
                System.out.print("Quantity: ");int qty = sc.nextInt();
                System.out.print("Price: ");   double price = sc.nextDouble();
                list.add(new Product(id, name, qty, price));
                saveFile();
                System.out.println("Added!");

            } else if (choice == 2) {
                if (list.isEmpty()) { System.out.println("No products yet."); }
                else { for (Product p : list) System.out.println(p); }

            } else if (choice == 3) {
                System.out.print("Enter ID: "); int sid = sc.nextInt();
                boolean found = false;
                for (Product p : list) {
                    if (p.id == sid) { System.out.println(p); found = true; break; }
                }
                if (!found) System.out.println("Not found.");

            } else if (choice == 4) {
                double total = 0;
                for (Product p : list) total += p.quantity * p.price;
                System.out.println("Total Value: $" + total);
            }

        } while (choice != 5);

        System.out.println("Bye!");
        sc.close();
    }

    // Save list to file
    static void saveFile() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
        out.writeObject(list);
        out.close();
    }

    // Load list from file
    static void loadFile() throws Exception {
        File f = new File(FILE);
        if (!f.exists()) return; // No file yet, that's fine
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE));
        list = (ArrayList<Product>) in.readObject();
        in.close();
    }
}
