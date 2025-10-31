import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class App extends JFrame {
    private JLabel statusLabel;
    private PetMachine petMachine = new PetMachine();
    private Scanner scanner = new Scanner(System.in);
    public App() {
        //configurações da janela
        setTitle("Pet Washing Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        statusLabel = new JLabel("Welcome to the Pet Washing Machine!");
        add(statusLabel);

        while (true) {
            System.out.println("1. Add Water");
            System.out.println("2. Add Shampoo");
            System.out.println("3. Set Pet");
            System.out.println("4. Take a Shower");
            System.out.println("5. Remove Pet");
            System.out.println("6. Wash Machine");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    petMachine.addWater();
                    break;
                case 2:
                    petMachine.addShampoo();
                    break;
                case 3:
                    String petName = JOptionPane.showInputDialog(this, "Input name the pet:");
                    if (petName != null && !petName.trim().isEmpty()) {
                        petName = "pet";
                    } else {
                        Pet pet = new Pet(petName,false);
                    }
                case 4:
                    petMachine.takeAShower();
                    break;
                case 5:
                    petMachine.removePet();
                    break;
                case 6:
                    petMachine.washMachine();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
