public class InvalidCityPincodeException extends Exception {
    /**
     * Exception is throws when city pincode
     * does not meed required sepecificatoin
     *
     * @param message "Invalid City Pincode"
     */
    public InvalidCityPincodeException(String message) {
        super(message);
    }
}
