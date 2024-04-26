import java.util.ArrayList;

public class FirstTask {
    //ფუნქცია რომელიც პარამეტრად იღებს მასივს მთელი რიცხვებისას
    static double averageBelow150(int[] numbers) {
        //ჯამი და რიცხვების რაოდენობა რათა დავიანგარიშოთ საშუალო
        int sum = 0;
        int count = 0;

        //ფორ ციკლი გავატაროთ რიცხვების მასივში და შევამოწმოთ თუ
        //ეს რიცხვი ნაკლებია 150 ზე გავზარდოთ ქაუნთი 1 ით და
        //ეს რიცხვი დავუმატოთ ზევით აღწერილ ჯამს
        for (int num : numbers) {
            if (num < 150) {
                sum += num;
                count++;
            }
        }

        // თუ მასივში არ მოიძებნა ისეთი რიცხვი რომელიც ნაკლებიუა 150-ზე
        // დავაბრუნოთ 0
        if (count == 0) {
            System.out.println("150 ზე ნაკლები რიცხვი არ მოიძებნა მასივში");
            return 0.0;
        }

        // დავაბრუნოთ საშუალო არითმეტიკული როგორც double
        return (double) sum / count;
    }

    //ფუნქცია რომელიც პარამეტრად იღებს მთელი რიცხვების მასივს
    static double calculateGeometricAverage(int [] numbers){
        double mult = 1;
        int count = 0;

        for (int num: numbers){
            if(num % 2 != 0){
                mult*= num;
                count++;
            }
        }

        //გეომეტრიული საშუალო ითვლება რიცხვების ნამრავლიდან ამოვიღოთ n ხარისხის ფესვი
        return Math.pow(mult, 1.0 / count);

    }

    // ვეძებთ ლისტში უდიდესი და უმცირესი რიცხვების საშუალო არითმეტიკულს
    public static double minMaxAverage(int[] numbers) {

        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        return (max + min) / 2.0;
    }
    // ვითვლით არრაიში უდიდესი და უმცირესი რიცხვების საშუალო გეომეტრიულს
    public static double minMaxGeometricAverage(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.sqrt((double) min * max);
    }

    //ვეძებთ n-დან m-მდე ყვალა პალინდრომ რიცხვს
    // --
    public static int[] findPalindromes(int n, int m) {
        ArrayList<Integer> palindromes = new ArrayList<>();

        for (int num = n; num <= m; num++) {
            if (isPalindrome(num)) {
                palindromes.add(num);
            }
        }
        int[] palindromeArray = new int[palindromes.size()];
        for (int i = 0; i < palindromes.size(); i++) {
            palindromeArray[i] = palindromes.get(i);
        }
        return palindromeArray;
    }

    private static boolean isPalindrome(int num) {
        String strNum = String.valueOf(num);
        int left = 0;
        int right = strNum.length() - 1;

        while (left < right) {
            if (strNum.charAt(left) != strNum.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    //----



    public static void main(String[] args) {
        // აღვწეროთ მასივი და მივანიჭოთ ელემენტები
        int[] array1 = {140, 130, 140, 180, 160};
        int[] array2 = {4, 5, 3, 12, 7};

        //გამოვიძახოთ ჩვენი ფუნქცია და არგუმენტად მივცეთ ჩვენი მასივი
        double average = averageBelow150(array1);
        double geoAverage = calculateGeometricAverage(array2);
        double _minMaxAverage = minMaxAverage(array2);
        double _minMaxGeometricAverage = minMaxGeometricAverage(array2);

        //დავბეჭდოთ შედეგი
        System.out.println("საშუალო არითმეტიკული: " + average);
        System.out.println("გეომეტრიული საშუალო: " + geoAverage);
        System.out.println("ლისტში უმცირესი და უდიდესი რიცხვების საშუალო არითმეტიკული: " + _minMaxAverage);
        System.out.println("ლისტში უმცირესი და უდიდესი რიცხვების საშუალო გეომეტრიული: " + _minMaxGeometricAverage);



        int n = 100;
        int m = 200;

        int[] palindromeArray = findPalindromes(n, m);
        System.out.println("Palindromes between " + n + " and " + m + ": ");
        for (int palindrome : palindromeArray) {
            System.out.print(palindrome + " ");
        }


    }
}
