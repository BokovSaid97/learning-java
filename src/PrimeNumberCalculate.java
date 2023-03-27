import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberCalculate {

    public int validator(String pole1, String pole2) {
        int error = 0;
        try {
            int num1 = (int)Math.ceil(Double.parseDouble(pole1));
            int num2 = (int)Math.ceil(Double.parseDouble(pole2));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Ошибка ввода! Повторитете попытку пожалуйста.");
        }
        int num1 = (int)Math.ceil(Double.parseDouble(pole1));
        int num2 = (int)Math.ceil(Double.parseDouble(pole2));
        if ((num1<0 && num2<0) || num2<=num1) {
            error = 1;
        }

        return error;
    }
        public List<Integer> prime(String pole1, String pole2) {
            int num1 = (int)Math.ceil(Double.parseDouble(pole1));
            int num2 = (int)Math.ceil(Double.parseDouble(pole2));
            if (num1 < 0) {
                num1 = 0;
            }
            boolean ar [] = new boolean[num2+1];
            Arrays.fill(ar,true);
            ar[0] = false;
            ar[1] = false;

            for (int i = 2; i < ar.length; i++) {
                if (ar[i]) {
                    for (int j = 2; i*j< ar.length; j++) {
                        ar[i*j] = false;
                    }
                }
                if (i<num1) {
                    ar[i] = false;
                }
            }

            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i < ar.length; i++) {
                if (ar[i]) {
                    primes.add(i);
                }
            }
            return primes;
        }

        public String getPrimeString(List<Integer> primes) {
            String pole3 = primes.stream().map(String::valueOf).collect(Collectors.joining(" "));
            return  pole3;
        }

        public String getPrimeSumEqualFive(List<Integer> primes) {
            List<String> sumFive = new ArrayList<>();
            for (int i = 0;i < primes.size(); i++) {
                int num = primes.get(i);
                int tmp = 0;
                for (; num > 0; num /= 10) {
                    tmp += num%10;
                }
                if (tmp == 5) {
                    sumFive.add(Integer.toString(primes.get(i)));
                }
            }
            String pole4 = String.join(" ", sumFive);
            return pole4;
        }

        public String getPrimeFullySumma(List<Integer> primes) {
            int summa = 0;
            for (int i = 0;i < primes.size(); i++) {
                int num = primes.get(i);
                for (; num > 0; num /= 10) {
                    summa += num%10;
                }
            }
            String pole5 = Integer.toString(summa);
            return pole5;
        }




}
