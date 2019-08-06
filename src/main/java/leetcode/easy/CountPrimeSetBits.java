package leetcode.easy;

/**
 * Created by Mr.Wang on 2019/7/30.
 */
public class CountPrimeSetBits {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        int calcuNum;
        for(int index = L; index <= R; index++){
            calcuNum = calculatorNum(index);
            if(isPrimeNum(calcuNum)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrimeNum(int num){
        if(num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num% i == 0){
                return false;
            }
        }
        return true;
    }

    public int calculatorNum(int num){
        int count = 0;
        while(num != 0){
            count++;
            num = num&(num-1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        System.out.println(countPrimeSetBits.countPrimeSetBits(10,15));
    }


}
