
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JLabel statusLabel, welcomeLabel;
    private PetMachine petMachine = new PetMachine(); 
    private Pet pet = new Pet("", false);

    public App() {

        String petName = JOptionPane.showInputDialog(this, "Input name the pet:");
                    if (petName != null && !petName.trim().isEmpty()) {
                        petName = "pet";
                    } else {
                        pet.setName(petName);
                        pet.setClean(false);
                    }

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
        buttonPanel.setBackground(Color.BLACK);
        JButton addWaterButton = new JButton("Add Water");
        JButton addShampooButton = new JButton("Add Shampoo");
        JButton setPetButton = new JButton("Set Pet");
        JButton takeShowerButton = new JButton("Take a Shower");
        JButton removePetButton = new JButton("Remove Pet");
        JButton washMachineButton = new JButton("Wash Machine");

        buttonPanel.add(addWaterButton);
        buttonPanel.add(addShampooButton);
        buttonPanel.add(setPetButton);
        buttonPanel.add(takeShowerButton);
        buttonPanel.add(removePetButton);
        buttonPanel.add(washMachineButton);

        add(buttonPanel, BorderLayout.SOUTH);

        //Button actions
        addWaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petMachine.addWater();
            }
        });
        takeShowerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                petMachine.takeAShower();
            }
        })
    }

    private String getPetStatus() {
    return pet.getName() + " is " + (pet.isClean() ? "clean" : "not clean");
    }
    public static void main(String[] args) {
        new App();
    }
}
