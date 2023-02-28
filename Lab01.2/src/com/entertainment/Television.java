package com.entertainment;
import java.util.Objects;

public class Television implements Comparable<Television> {
    // fields or instance variables
    private String brand;
    private int volume;

    // Television HAS-A Tuner, delegates all
    private Tuner tuner = new Tuner();  // instantiated internally

    // Constructors
    public Television() {

    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    // business method
    public int getCurrentChannel() {
        return tuner.getChannel();  // delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);  // delegate to contained Tuner object
    }

    // accessor method
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

/*    @Override
    public boolean equals(Object obj) {
        // if television object same as the physical object as obj
        if (this == obj) return true;

        // if obj is null OR I and obj are not the same EXACT type
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Television that = (Television) obj;
        return this.getVolume() == that.getVolume() &&
                    Objects.equals(this.getBrand(), that.getBrand());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }
*/
    /*
     * @Override
     * public boolean equals(Object obj) {
     * boolean result = false;
     * // this (me) and obj refer to the same physical object in memory!
     * if (this == obj) {
     * result = true;
     * // obj is not null nd my class object is the same as its class object
     * else if (obj != null && (this.getClass() == obj.getClass())) {
     * Television other = (Television) obj;
     * result = Objects.equals(this.getBrand(), other.getBrand()) &&
                     this.getVolume() == other.getVolume();
     * } return result; }
     */

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Television) {
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    Objects.equals(this.getVolume(), other.getVolume());
        }
        return result;
    }
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Television that = (Television) o;
//        return getVolume() == that.getVolume() && Objects.equals(getBrand(), that.getBrand());
//

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public int compareTo(Television other) {
        return this.getBrand().compareTo(other.getBrand());
    }

    @Override
    public String toString() {
        return String.format("%s[brand=%s , volume=%s, currentChannel=%s]",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}
