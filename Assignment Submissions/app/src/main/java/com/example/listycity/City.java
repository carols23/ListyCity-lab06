package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {

    private String city;
    private String province;

    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     * @return the city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the name of the province.
     * @return the province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city by name.
     * @param o another City object
     * @return comparison result based on city name
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // compare city names
    }

    /**
     * Checks if two City objects are equal based on their city and province names.
     * @param o the object to compare
     * @return true if both have the same city and province, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City c = (City) o;
        return this.city.equals(c.getCityName()) && this.province.equals(c.getProvinceName());
    }

    /**
     * Returns a hash code based on the city and province names.
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return this.city.hashCode() + this.province.hashCode();
    }
}
