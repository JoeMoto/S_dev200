package Mod2PA3;

public class assign12_9 {
    // Convert a binary string to a decimal integer
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the string is a valid binary string (contains only '0' and '1')
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // If valid, convert binary string to a decimal integer
        int decimalValue = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            decimalValue = decimalValue * 2 + (binaryString.charAt(i) - '0');
        }

        return decimalValue;
    }
}
