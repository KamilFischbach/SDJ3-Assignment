package via.sdj3.slaughterhouse.restAPI.model;

import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Animal {
    private int regId;
    private LocalDateTime dateTime;
    private double weight;
    private String origin;

    public Animal(int regId, LocalDateTime dateTime, double weight, String origin) {
        this.regId = regId;
        this.dateTime = dateTime;
        this.weight = weight;
        this.origin = origin;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return regId == animal.regId && Double.compare(animal.weight, weight) == 0 && Objects.equals(dateTime, animal.dateTime) && Objects.equals(origin, animal.origin);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "regId=" + regId +
                ", dateTime=" + dateTime +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
