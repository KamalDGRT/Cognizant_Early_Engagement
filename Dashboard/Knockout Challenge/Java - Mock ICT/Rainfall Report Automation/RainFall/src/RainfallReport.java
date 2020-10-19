import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RainfallReport {
    /**
     * This method should validate the city pincode,
     * if valid return true
     * else this method should throw an userdefined exception
     *
     * @param cityPincode Pin code of a city
     * @return true if valid pincode
     * @throws InvalidCityPincodeException is thrown if pincode is invalid (must only consist of 5 digits)
     */
    public boolean validate(String cityPincode) throws InvalidCityPincodeException {
        Pattern pattern = Pattern.compile("^\\d{5}$");
        Matcher matcher = pattern.matcher(cityPincode);

        if (matcher.matches()) {
            return true;
        } else {
            throw new InvalidCityPincodeException("Invalid City Pincode");
        }
    }

    /**
     * Generate a list of AnnualRainfall by retrieving data from a file
     *
     * @param filePath path to the file where data is stored
     * @return List of AnnualRainfall
     * @see AnnualRainfall
     */
    public List<AnnualRainfall> generateRainfallReport(String filePath) {
        List<AnnualRainfall> annualRainfallList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            Scanner scanner = new Scanner(bufferedReader);

            while (scanner.hasNext()) {
                String[] records = scanner.nextLine().split(",");
                String cityPincodeStr = records[0];
                boolean correctPin = false;
                try {
                    correctPin = validate(cityPincodeStr);

                    if (correctPin) {
                        int cityPincode = Integer.parseInt(cityPincodeStr);
                        String cityName = records[1];
                        double[] monthlyRainfalls = new double[12];

                        for (int i = 0; i < 12; ++i) {
                            double monthlyRainfall = Double.parseDouble(records[i + 2]);
                            monthlyRainfalls[i] = monthlyRainfall;
                        }

                        AnnualRainfall annualRainfall = new AnnualRainfall();
                        annualRainfall.setCityPincode(cityPincode);
                        annualRainfall.setCityName(cityName);
                        annualRainfall.calculateAverageAnnualRainfall(monthlyRainfalls);
                        annualRainfallList.add(annualRainfall);
                    }
                } catch (InvalidCityPincodeException e) {
                    System.out.println(e.getMessage());
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return annualRainfallList;
    }

    /**
     * This method should extract all the AnnualRainfall details from
     * the AnnualRainfall table and
     * return the list of cities with maximum averageAnnualRainfall.
     *
     * @return List of AnnualRainfall
     * @see DBHandler
     * @see AnnualRainfall
     */
    public List<AnnualRainfall> findMaximumRainfallCities() {
        List<AnnualRainfall> maximumRainfallCities = new ArrayList<>();

        try {
            Connection connection = new DBHandler().establishConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *\n" +
                    "from AnnualRainfall\n" +
                    "where average_annual_rainfall = (\n" +
                    "    select max(average_annual_rainfall)\n" +
                    "    from AnnualRainfall\n" +
                    ");");

            while (resultSet.next()) {
                int cityPincode = resultSet.getInt(1);
                String cityName = resultSet.getString(2);
                double averageAnnualRainfall = resultSet.getDouble(3);

                AnnualRainfall annualRainfall = new AnnualRainfall();
                annualRainfall.setCityPincode(cityPincode);
                annualRainfall.setCityName(cityName);
                annualRainfall.setAverageAnnualRainfall(averageAnnualRainfall);
                maximumRainfallCities.add(annualRainfall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return maximumRainfallCities;
    }
}
