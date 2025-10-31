public class PetMachine {
    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;
    
    public int getWater() {
        return water;
    }


    public int getShampoo() {
        return shampoo;
    }


    public boolean isClean() {
        return clean;
    }


    public void setClean(boolean clean) {
        this.clean = clean;
    }


    public void setPet(Pet pet) {
        if(!this.clean) {
            System.out.println("Machine is not clean. Cannot add a pet.");
            return;
        }
        if(hasPet()) {
            System.out.println("A pet is already in the machine.");
            return;
        }
        this.pet = pet;
    }


    public void takeAShower() {
        if (this.pet == null) {
           System.out.println("No pet available for shower. Get a pet first.");
            return;
            } else {
           System.out.println("Giving " + pet.getName() + " a shower.");
           this.water -= 10;
           this.shampoo -= 2;
           pet.setClean(true);
           System.out.println(pet.getName() + " is now clean.");
        }
    }


    public void addWater() {
        if (this.water == 30) {
            System.out.println("Water limit exceeded. Cannot add more water.");
            return;
        }
        this.water += 2;
        System.out.println("Added 2 units of water.");
    }

    public void addShampoo() {
        if (this.shampoo == 10) {
            System.out.println("Shampoo limit exceeded. Cannot add more shampoo.");
            return;
        }
        this.shampoo += 2;
        System.out.println("Added 2 units of shampoo.");
    }

    public void verifyWater(){
        System.out.println("Current water level: " + this.water);
    }
    public void verifyShampoo(){
        System.out.println("Current shampoo level: " + this.shampoo);
    }
    public boolean hasPet() {
        return pet != null;
    }
    public void removePet() {
        this.clean = this.pet.isClean();
        System.out.println("Removing " + pet.getName() + " from the machine.");
        this.pet = null;
    }
    public void washMachine() {
        this.clean = true;
        this.water -= 10;
        this.shampoo -= 2;
        System.out.println("Washing machine...");
    }
}

