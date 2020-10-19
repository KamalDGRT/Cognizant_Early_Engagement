public class AnnualRainfall {
    private int cityPincode;
    private String cityName;
    private double averageAnnualRainfall;

    public int getCityPincode() {
        return cityPincode;
    }

    public void setCityPincode(int cityPincode) {
        this.cityPincode = cityPincode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getAverageAnnualRainfall() {
        return averageAnnualRainfall;
    }

    public void setAverageAnnualRainfall(double averageAnnualRainfall) {
        this.averageAnnualRainfall = averageAnnualRainfall;
    }

    /**
     * This method should calculate and
     * set the averageAnnualRainfall based on
     * the monthly rainfall  the city received
     *
     * @param monthlyRainfalls Array of double of monthly rainfall
     */
    public void calculateAverageAnnualRainfall(double[] monthlyRainfalls) {
        double totalAnnualRainfall = 0;

        for (double monthlyRainfall : monthlyRainfalls) {
            totalAnnualRainfall += monthlyRainfall;
        }

        averageAnnualRainfall = totalAnnualRainfall / 12.0;
    }
}
