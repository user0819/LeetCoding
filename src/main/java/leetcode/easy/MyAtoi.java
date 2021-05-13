package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XIANG
 * @since 2020/4/7 13:01
 *
 * 	        ' '	    +/-	    number	    other
 * start	start	signed	number	    end
 * signed	end	    end	    number  	end
 * number	end	    end	    number  	end
 * end	    end	    end	    end	        end
 *
 */
public class MyAtoi {

    private Map<String,String[]> statusMachine;
    private final static String START = "start";
    private final static String SIGN = "sign";
    private final static String NUMBER = "number";
    private final static String END = "end";
    private long result = 0;
    private String status = START;
    private int sign_result = 1;

    public MyAtoi(){
        statusMachine = new HashMap<>();
        statusMachine.put(START,new String[]{START,SIGN,NUMBER,END});
        statusMachine.put(SIGN,new String[]{END,END,NUMBER,END});
        statusMachine.put(NUMBER,new String[]{END,END,NUMBER,END});
        statusMachine.put(END,new String[]{END,END,END,END});
    }


    public int getStatusCol(char c) {
        if (c == ' ') return 0;
        if (c == '+' || c == '-') return 1;
        if (c >= '0' && c <= '9') return 2;
        return 3;
    }

    public void get(char c) {
        status = statusMachine.get(status)[getStatusCol(c)];
        if (status.equals(NUMBER)) {
            result = result * 10 + c - '0';
            if (sign_result == 1) {
                result = Math.min(result, Integer.MAX_VALUE);
            } else {
                // -(long)Integer.MIN_VALUE，这个操作有点东西，不然越界
                result = Math.min(result, -(long)Integer.MIN_VALUE);
            }
        } else if (status.equals(SIGN))
            sign_result = c == '+' ? 1 : -1;
    }

    public static int myAtoi(String str) {
        MyAtoi automaton = new MyAtoi();
        char[] c = str.toCharArray();
        for (char ch : c) {
            automaton.get(ch);
        }
        return automaton.sign_result * ((int) automaton.result);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi( "   -1254"));

    }


}
