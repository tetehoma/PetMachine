import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
    private JLabel statusLabel, welcomeLabel;
    private PetMachine petMachine = new PetMachine(); 
    private Pet pet = new Pet("", false);
    private Scanner scanner = new Scanner(System.in);

    public App() {
        //window configuration
        setTitle("Pet Washing Machine");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //layout configuration
        setLayout(new BorderLayout());

        //Label welcome
        welcomeLabel = new JLabel("Welcome to the Pet Washing Machine!");
        add(welcomeLabel, BorderLayout.NORTH);
        setVisible(true);

        //Label status
        statusLabel = new JLabel(getPetStatus(), SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(statusLabel, BorderLayout.CENTER);

        //Buttons and menu
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2));
        JButton addWaterButton = new JButton("Add Water");
        JButton addShampooButton = new JButton("Add Shampoo");
        JButton setPetButton = new JButton("Set Pet");
        JButton takeShowerButton = new JButton("Take a Shower");
        JButton removePetButton = new JButton("Remove Pet");
        JButton washMachineButton = new JButton("Wash Machine");
    
            removePetButton.addActionListener(e -> {
                petMachine.removePet();
                statusLabel.setText(getPetStatus());
            });

        buttonPanel.add(addWaterButton);
        buttonPanel.add(addShampooButton);
        buttonPanel.add(setPetButton);
        buttonPanel.add(takeShowerButton);
        buttonPanel.add(removePetButton);
        buttonPanel.add(washMachineButton);

        add(buttonPanel, BorderLayout.SOUTH);

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
                        pet.setName(petName);
                        pet.setClean(false);
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

    private String getPetStatus() {
    return pet.getName() + " is " + (pet.isClean() ? "clean" : "not clean");
    }
    public static void main(String[] args) {
        new App();
    }
}
