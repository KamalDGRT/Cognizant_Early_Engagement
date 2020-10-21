import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ElectricityBoard electricityBoard = new ElectricityBoard();

        List<ElectricityBill> billList = electricityBoard.generateBill("ElectricityBill.txt");

        System.out.println("Bills parsed from file...");
        for (ElectricityBill bill : billList) {
            System.out.println(String.format("id: %s, name: %s, address: %s, units: %d, bill: %f",
                    bill.getConsumerNumber(),
                    bill.getConsumerName(),
                    bill.getConsumerAddress(),
                    bill.getUnitsConsumed(),
                    bill.getBillAmount())
            );
        }

        // Adding bills to the database
        electricityBoard.addBill(billList);

        Connection connection = new DBHandler().establishConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from ElectricityBill");

        System.out.println("Bills retrieved from database ElectricityBill...");

        while (resultSet.next()) {
            String consumerNumber = resultSet.getString(1);
            String consumerName = resultSet.getString(2);
            String consumerAddress = resultSet.getString(3);
            int unitsConsumed = resultSet.getInt(4);
            float billAmount = resultSet.getFloat(5);

            System.out.println(String.format("id: %s, name: %s, address: %s, units: %d, bill: %f",
                    consumerNumber,
                    consumerName,
                    consumerAddress,
                    unitsConsumed,
                    billAmount)
            );
        }
    }
}