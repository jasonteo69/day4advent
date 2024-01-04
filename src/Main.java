import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File f = new File("data/inputFile");
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found buddy.");
            System.exit(1);
        }
        String fileData = "";
        String[] cards = new String[6];
        int cardNumber = 0;


        while (s.hasNextLine()) {
            fileData = s.nextLine() + "\n";
            String[] fileArray = fileData.split("\n");
            String realFileData = Arrays.toString(fileArray);

            int colonIndex = realFileData.indexOf(":") + 1;
            int separationIndex = realFileData.indexOf("|");
            int separationIndex2 = realFileData.indexOf("|") + 1;

            String winningNum = realFileData.substring(colonIndex, separationIndex).trim();
            String[] winningNumbers = winningNum.split(" ");
            String userNum = realFileData.substring(separationIndex2).trim();
            String[] userNumbers = userNum.split(" ");

            System.out.println(Arrays.toString(winningNumbers));

            cardNumber = Integer.parseInt(realFileData.substring(6, 7));
            System.out.println(cardNumber);

            int[] realWin = new int[winningNumbers.length];
            int[] realUser = new int[userNumbers.length];
            for (int i = 0; i < winningNumbers.length; i++) {
                realWin[i] += Integer.parseInt(winningNumbers[i]);
            }
            for (int i = 0; i < winningNumbers.length; i++) {
                realUser[i] += Integer.parseInt(userNumbers[i]);
            }
        }
    }
}