package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd(){

        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
    // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = new CityList();
        City city = new City("Edmonton", "AB");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = new CityList();
        City city = new City("Calgary", "AB");
        cityList.add(city);
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testDeleteNonExistentCity() {
        CityList cityList = new CityList();
        City city = new City("Vancouver", "BC");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }

    @Test
    public void testCountCities() {
        CityList cityList = new CityList();
        cityList.add(new City("Toronto", "ON"));
        cityList.add(new City("Calgary", "AB"));
        assertEquals(2, cityList.countCities());
    }

    @Test
    public void testGetCitiesSorted() {
        CityList cityList = new CityList();
        City edmonton = new City("Edmonton", "AB");
        City calgary = new City("Calgary", "AB");
        cityList.add(edmonton);
        cityList.add(calgary);
        assertEquals(calgary, cityList.getCities().get(0)); // Calgary < Edmonton
    }


}