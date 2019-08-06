package leetcode.easy;



/**
 * Created by Mr.Wang on 2019/6/20.
 */
public class FindWords {
    public static String[] findWords(String[] words) {
        String FLine = "qwertyuiop";
        String SLine = "asdfghjkl";
        String TLine = "zxcvbnm";

        java.util.List<String> list = new java.util.ArrayList();

        String baseString = "";
        for(String word: words){
            if(word==""){continue;}

            String lowerCaseWord = word.toLowerCase();
            baseString = "";
            char firstChar = lowerCaseWord.charAt(0);
            if(FLine.indexOf(firstChar) >= 0 ){
                baseString = FLine;
            }else if(SLine.indexOf(firstChar) >= 0){
                baseString = SLine;
            }else if(TLine.indexOf(firstChar) >= 0 ){
                baseString = TLine;
            }else{
                continue;
            }

            boolean sameLine = true;
            for(int i = 1; i< lowerCaseWord.length(); i++){
                if(baseString.indexOf(lowerCaseWord.charAt(i))<0){
                    sameLine = false;
                    break;
                }
            }
            if(sameLine){
                list.add(word);
            }
        }
        String[] B = new String[list.size()];
        return list.toArray(B);
    }

    public static void main(String[] args) {
        System.out.println(findWords(new String[]{"aasdsf","qwer","wasz"}));
    }
}
