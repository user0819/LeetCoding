package leetcode.middle;

import java.util.Date;
import java.util.Stack;

/**
 * Created by Mr.Wang on 2019/8/6.
 */
public class NumIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    BFS(grid,i,j);
                }
            }
        }
        return count;
    }

    //深度遍历
    public static void DFS(char[][] grid,int i, int j){
        if(i<0 || i>= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        DFS(grid,i-1,j);
        DFS(grid,i+1,j);
        DFS(grid,i,j-1);
        DFS(grid,i,j+1);
    }

    public static void BFS(char[][] grid,int i, int j){
        Stack<int[]> stack = new Stack<>();
        int[] arrayIndex;
        stack.push(new int[]{i,j});
        while(!stack.isEmpty()){
            arrayIndex = stack.pop();
            i = arrayIndex[0];
            j = arrayIndex[1];
            grid[i][j] = '0';
            if(i-1 >= 0 && grid[i-1][j] =='1'){
                stack.push( new int[]{i-1,j});
            }
            if(i+1 < grid.length && grid[i+1][j] =='1'){
                stack.push( new int[]{i+1,j});
            }
            if(j-1 >=0 && grid[i][j-1] =='1'){
                stack.push( new int[]{i,j-1});
            }
            if(j+1 < grid[i].length && grid[i][j+1] =='1'){
                stack.push( new int[]{i,j+1});
            }
        }
    }

    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();

        long begin = System.currentTimeMillis();
        long memory1 = run.freeMemory();
        for (int i = 0; i < 100000 ; i++) {
            char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
            numIslands(grid);
        }


        long end = System.currentTimeMillis();
        long memory2 = run.freeMemory();
        System.out.println("用时：" + (end -begin));
        System.out.println("占用内存：" + (memory1 -memory2));
    }
}
