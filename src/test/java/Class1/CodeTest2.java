package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

public class CodeTest2 {

    /**
     * Ques-1:
     * Create a method to return factorial value of input-int-value
     * points: 10
     */
    /*
     *
     * eg:
     * input -> 5
     * returned value -> (5*4*3*2*1) = 120
     *
     * input -> 1
     * returned value -> (1) = 1
     *
     * input -> 3
     * returned value -> (3*2*1) = 6
     *
     * input -> 10
     * returned value -> (10*9*8*7*6*5*4*3*2*1) =
     */
    public static void main(String args[]) {
        int i, fact = 1;
        int number = 5; //get factorial of 5
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + number + " is: " + fact);
    }

    /**
     * Ques-2:
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */

    @Test
    public void verifyRealFeel() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net/");

        String realFeel = MyDriver.getDriver().findElement(By.xpath("//*[@class='feels-like-text']")).getText();

        String tempLow = MyDriver.getDriver().findElement(By.xpath("//*[@class='low-temp-text']")).getText();

        String tempHigh = MyDriver.getDriver().findElement(By.xpath("//*[@class='high-temp-text']")).getText();

        int newFeelsTemp = Integer.valueOf(realFeel.split("˚")[0]);

        int newLowTemp = Integer.valueOf(tempLow.split("˚")[0]);

        int newHighTemp = Integer.valueOf(tempHigh.split("˚")[0]);

        if (newFeelsTemp > newLowTemp && newFeelsTemp < newHighTemp) {Assert.assertTrue(true);
        } else {Assert.assertTrue(false);
        }

        /**
         * Ques-3:
         * Create a method to return the common Strings values in two input-String-arrays
         * points: 30
         * Note: two input-String-arrays can be of same size or different size
         */
        /*
         *
         * eg:
         * input -> {"happY", "king", "peace", "living standard"} , {"king kong", "Happy", "PEACE"}
         * returned value -> [happy, peace]
         *
         * input -> {“ab”, “abcd”, “abc”, “abcde”, “defg”, "koli”} , {“abcde”, “jhuy”, “plot”, “koli”}
         * returned value -> [abcde, koli]
         *
         */
            public static void main(String[] args) {

                String[] array1 = {"Hello", "my", "name", "is", "Aumi"};

                String[] array2 = {"Aumi", "is", "away", "on", "vacation"};

                System.out.println("Array1 : " + Arrays.toString(array1));
                System.out.println("Array2 : " + Arrays.toString(array2));

                HashSet<String> set = new HashSet<String>();

                for (int i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array2.length; j++) {
                        if (array1[i].equals(array2[j])) {
                            set.add(array1[i]);
                        }
                    }
                }

                System.out.println("Common element : " + (set));
            }

            /**
             * Ques-4:
             * Create a method to return missing smallest positive integer (greater than 0) from given int-array.
             * points: 40
             */
            /*
             *
             * eg:
             * 	input -> : {3, 5, 1, 4, 2, 7}
             * 	returned value : 6
             *
             * 	input -> : {3, 5, 1, 4, 2}
             * 	returned value : 6
             *
             * 	input -> {2, 5, -1, 0, 6}
             * 	returned value : 1
             *
             * 	input -> {0, 5, -1, 1, 2, 5, 3, 7, 1, 2}
             * 	returned value : 4
             *
             * 	input -> {-2, -5, -1, -10, -6}
             * 	returned value : 1
             *
             */
            static int findMissingNo(int[] arr, int n) {
                // to store current array element
                int val;
                // to store next array element in
                int nextval;
                for (int i = 0; i < n; i++) {
                    // if value is negative or greater than array size, then it cannot be marked in array. So move to next element.
                    if (arr[i] <= 0 || arr[i] > n)
                        continue;
                    val = arr[i];
                    // traverse the array until we reach at an element which is already marked or which could not be marked.
                    while (arr[val - 1] != val) {
                        nextval = arr[val - 1];
                        arr[val - 1] = val;
                        val = nextval;
                        if (val <= 0 || val > n)
                            break;
                    }
                }
                // find first array index which is not marked which is also the smallest positive missing number.
                for (int i = 0; i < n; i++) {
                    if (arr[i] != i + 1) {
                        return i + 1;
                    }
                }
                // if all indices are marked, then smallest missing positive number is array_size + 1.
                return n + 1;
            }

            public static void main(String[] args) {
                int arr[] = {2, 3, 7, 6, 8, -1, -10, 15};
                int arr_size = arr.length;

                int missing = findMissingNo(arr, arr_size);

                System.out.println("The smallest positive"
                        + " missing number is " + missing);
            }
        }
    }

