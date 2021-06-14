public class StringManipulator{
    public String trimAndConcat(String str1, String str2){
    String trim1 =  str1.trim();
    String trim2 =  str2.trim();
    String str3 = trim1.concat(trim2);
    return str3;
    }

public Integer GetIndexOrNull(String s1, char c1){
        if (s1.indexOf(c1) >= 0){
            return s1.indexOf(c1);
        }
        else {
            return null;
        }
    }
public Integer GetIndexOrNull(String s2, String s3){
        if (s2.indexOf(s3) >= 0){
            return s2.indexOf(s3);
        }
        else {
            return null;
        }
    }

String concatSubstring(String s1, int num1, int num2, String s2){
    return s1.substring(num1, num2).concat(s2);
}
}