package via.sdj3.slaughterhouse.restAPI.model;

public class AnimalDTO {
    private String origin;
    private double weight;

    public AnimalDTO(String origin, double weight) {
        this.origin = origin;
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
