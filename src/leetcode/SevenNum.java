package leetcode;

public class SevenNum {
    public static void main(String[] args) {
        input = new int[]{1,2,3};
        tmpres = new StringBuffer();
        count = 0 ;
        judge = new boolean[input.length];
        new SevenNum().dfs(0);
        System.out.println(count);
    }

    static int[] input ;
    static StringBuffer tmpres ;
    static int count ;
    static boolean[] judge ;

    public void dfs(int level) {
        if (level >= input.length)  {
            if (isSeveNum(Integer.parseInt(tmpres.toString())))
                count++;
            return;
        }

        for (int i = 0 ; i < input.length ; i++) {
            if (!judge[i]) {
                tmpres.append(String.valueOf(input[i]));
                judge[i] = true ;
                dfs(level + 1) ;
                judge[i] = false ;
                tmpres.deleteCharAt(tmpres.length() - 1);
            }
        }
    }

    private boolean isSeveNum(int tmpres) {
        if (tmpres % 7 == 0) return true;
        return false ;
    }

}
