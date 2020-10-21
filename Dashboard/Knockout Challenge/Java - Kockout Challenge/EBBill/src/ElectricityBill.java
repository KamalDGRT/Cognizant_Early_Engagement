public class ElectricityBill {
    private String consumerNumber;
    private String consumerName;
    private String consumerAddress;
    private int unitsConsumed;
    private double billAmount;

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerAddress() {
        return consumerAddress;
    }

    public void setConsumerAddress(String consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public void calculateBillAmount() {
        billAmount = 0;
        int tempUnits = unitsConsumed;


        if (tempUnits > 100) {
            tempUnits -= 100;

            if (tempUnits > 200) {
                tempUnits -= 200;
                billAmount += 200 * 1.5;

                if (tempUnits > 300) {
                    tempUnits -= 300;
                    billAmount += 300 * 3.5;

                    if (tempUnits > 400) {
                        tempUnits -= 400;
                        billAmount += 400 * 5.5;
                        billAmount += tempUnits * 7.5;
                    } else {
                        billAmount += tempUnits * 5.5;
                    }
                } else {
                    billAmount += tempUnits * 3.5;
                }
            } else {
                billAmount += tempUnits * 1.5;
            }
        }
    }
}