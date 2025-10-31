public class Pet {
    private final String name;
    private Boolean clean;

    public Pet(String name, Boolean clean) {
        this.name = name;
        this.clean = false;
    }

    public String getName() {
        return name;
    }

    public Boolean isClean() {
        return clean;
    }
    public void setClean(Boolean clean) {
        this.clean = clean;
    }


}
