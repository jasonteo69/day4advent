import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
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
        int cardNumber = 0;
        int scoring = 0;

        while (s.hasNextLine()) {
            fileData = s.nextLine() + "\n";
            String[] fileArray = fileData.split("\n");
            String realFileData = Arrays.toString(fileArray);

            int indexofColon = realFileData.indexOf(":");
            int firstSpace = realFileData.indexOf(" ");
            String gameNumber = realFileData.substring(firstSpace, indexofColon).trim();


            int colonIndex = realFileData.indexOf(":") + 1;
            int separationIndex = realFileData.indexOf("|");
            int separationIndex2 = realFileData.indexOf("|") + 1;

            String winningNum = realFileData.substring(colonIndex, separationIndex).trim();
            String[] winningNumbers = winningNum.split(" ");


            String userNum = realFileData.substring(separationIndex2, realFileData.length() - 1).trim();
            String[] userNumbers = userNum.split(" ");

            int[] realWin = new int[winningNumbers.length];
            int[] realUser = new int[userNumbers.length];

            for (int i = 0; i < winningNumbers.length; i++) {
                if (Objects.equals(winningNumbers[i], "")) {
                    i++;
                }
                realWin[i] += Integer.parseInt(winningNumbers[i].trim());
            }
            System.out.println(Arrays.toString(realWin));

            for (int i = 0; i < userNumbers.length; i++) {
                if (Objects.equals(userNumbers[i], ""))
                    i++;
                realUser[i] += Integer.parseInt(userNumbers[i].trim());
            }
            System.out.println(Arrays.toString(realUser));

            ScratchCard realCards = new ScratchCard(cardNumber, realWin, realUser);
            int totalScore = 0;
            totalScore += realCards.matches(realWin, realUser);
            scoring += totalScore;
            System.out.println(totalScore);
        }
        System.out.println(scoring);
    }
}