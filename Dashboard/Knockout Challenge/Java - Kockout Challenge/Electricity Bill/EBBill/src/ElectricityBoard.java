import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElectricityBoard {
    public boolean validate(String consumerNumber) throws InvalidConsumerNumberException {
        Pattern pattern = Pattern.compile("^0\\d{9}$");
        Matcher matcher = pattern.matcher(consumerNumber);

        if (matcher.matches()) {
            return true;
        } else {
            throw new InvalidConsumerNumberException("Invalid Consumer Number");
        }
    }


    public void addBill(List<ElectricityBill> billList) {
        Connection connection = new DBHandler().establishConnection();

        try {
            for (ElectricityBill bill : billList) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into ElectricityBill values(?,?,?,?,?);");
                preparedStatement.setString(1, bill.getConsumerNumber());
                preparedStatement.setString(2, bill.getConsumerName());
                preparedStatement.setString(3, bill.getConsumerAddress());
                preparedStatement.setInt(4, bill.getUnitsConsumed());
                preparedStatement.setFloat(5, (float) bill.getBillAmount());

                int result = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ElectricityBill> generateBill(String filePath) {
        List<ElectricityBill> electricityBills = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filePath)));

            while (scanner.hasNext()) {
                String[] inputs = scanner.nextLine().split(",");

                try {
                    String consumerNumber = inputs[0];
                    boolean validConsumerNumber = validate(consumerNumber);

                    if (validConsumerNumber) {
                        String consumerName = inputs[1];
                        String consumerAddress = inputs[2];
                        int unitsConsumed = Integer.parseInt(inputs[3]);

                        ElectricityBill electricityBill = new ElectricityBill();
                        electricityBill.setConsumerNumber(consumerNumber);
                        electricityBill.setConsumerName(consumerName);
                        electricityBill.setConsumerAddress(consumerAddress);
                        electricityBill.setUnitsConsumed(unitsConsumed);
                        electricityBill.calculateBillAmount();
                        electricityBills.add(electricityBill);
                    }
                } catch (InvalidConsumerNumberException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return electricityBills;
    }

}
