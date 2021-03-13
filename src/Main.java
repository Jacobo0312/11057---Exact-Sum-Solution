import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
        int books = sc.nextInt();
        int[] prices = new int[books];
        for (int i = 0; i < books; i++) {
            prices[i] = sc.nextInt();
        }
        int money = sc.nextInt();
        Arrays.sort(prices);

        int[] result = exactSum(prices, money);
        System.out.println("Peter should buy books whose prices are " + result[0] + " and " + result[1] + ".\n");
        
    }
    sc.close();
    
    }


    private static int[] exactSum(int[] prices, int money) {
        int[] array = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int search = money - prices[i];

            int diff = Math.abs(prices[i] - search);

            int x = bSearch(prices, search);

            if (x >= 0 && x != i && diff<minDiff) {
                    minDiff = diff;
                    array[0] = prices[i];
                    array[1] = prices[x];
                

            }
        }

        Arrays.sort(array);
        return array;
    }


    private static int bSearch(int[] array,int x) {
        int i=0;
        int j =array.length-1;
        while (i <= j ) {
            int m = (j + i) / 2;
            if (array[m] == x) {
                return m;
            } else if (array[m] > x) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }
    

}
