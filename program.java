import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * program
 */
public class program {

    public static void main(String[] args) throws IOException {

        int[] fR = failReed("text.txt");
        int a = fR[0];
        int b = fR[1];
        System.out.println(a);
        System.out.println(b);
        double result = expon(a, b);
        System.out.print(result);
        writeToFail("output.txt", result);
    }

    public static void writeToFail(String fileName, Double data) throws IOException {

        try (FileWriter fw = new FileWriter(fileName, true)) {
            if (data == -1.0) {
                fw.write("ответ: не определен");
                fw.append('\n');
                fw.flush();

            } else {
                fw.write("ответ: " + String.valueOf(data));
                fw.append('\n');
                fw.flush();
            }
        }
    }

    public static double expon(int a, int n) {
        double result = 1;
        if (a == 0)
            return -1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= a;
            }
            return result;
        }
        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                result *= a;
            }
            return 1.0 / result;
        }
        return result;
    }

    public static int[] failReed(String fileName) throws IOException {
        int[] inputNam = new int[2];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        boolean flag = false, convert = false;
        while ((str = br.readLine()) != null) {
            char[] strArray = str.toCharArray();
            for (char item : strArray) {
                if (item == '-') {
                    convert = true;
                }
                if (item == 'a') {
                    flag = true;
                }
                if (item == 'b') {
                    flag = false;
                }

                if (Character.isDigit(item) && flag) {
                    if (inputNam[0] != 0) {
                        inputNam[0] *= 10 + Character.getNumericValue(item);
                    } else {
                        inputNam[0] = Character.getNumericValue(item);
                        if (convert) {
                            inputNam[0] *= -1;
                        }
                    }
                    // System.out.println(inputNam[0]);
                    // System.out.println(item);
                }
                if (Character.isDigit(item) && !flag) {
                    if (inputNam[1] != 0) {
                        inputNam[1] *= 10 + Character.getNumericValue(item);
                    } else {
                        inputNam[1] = Character.getNumericValue(item);
                        if (convert) {
                            inputNam[1] *= -1;
                        }
                        // System.out.println(inputNam[1]);
                        // System.out.println(item);
                    }

                }
            }

        }
        return inputNam;
    }
}
