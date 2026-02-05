package org.example.weather;

public class OutfitAdvisor {
    private final WeatherService weatherService;

    public OutfitAdvisor(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getClothingAdvice() {
        if(weatherService.getTemperature() < 0 )
            return "Vinterjacka";
        return null;
    }
}
