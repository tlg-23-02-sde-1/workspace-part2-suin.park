package com.entertainment;
import java.util.Objects;

public class Television {
    // fields or instance variables
    private String brand;
    private int volume;

    // Television HAS-A Tuner, delegates all
    private Tuner tuner = new Tuner();  // instantiated internally

    // Constructors
    public Television () {

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

    @Override
    public boolean equals(Object obj) { // Television is an Object
        boolean result = false;

        // proceed only if 'obj' is reall a reference to a Television object
        if(obj instanceof Television) {
            // downcast to more specific type Television, so we can call Television methods
            Television other = (Television) obj;

            // do the checks: brands are the same AND volumes are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) && // null-safe check
                     this.getVolume() == other.getVolume();  // int can't be null
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s[brand=%s , volume=%s, currentChannel=%s]",
                getClass().getSimpleName(),getBrand(),getVolume(),getCurrentChannel());
    }
}