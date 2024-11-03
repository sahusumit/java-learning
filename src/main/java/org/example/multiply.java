package org.example;

import java.util.Objects;

public class multiply {

    public String multiplyTwoStrings(String n1, String n2){
        if(Objects.equals(n1, "0") || Objects.equals(n2, "0")){
            return "0";
        }
        int len1 = n1.length();
        int len2 = n2.length();
        int [] ans = new int[len1 + len2];
        for(int i = ans.length-1; i>=0; i--){
            ans[i]=0;
        }

        for (int i = len1-1; i >= 0; i--) {
            for (int j = len2-1; j>=0; j--) {
                int mul = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
                int sum = mul + ans[i + j + 1];
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }

        StringBuilder str1 = new StringBuilder();
        for (int an : ans) {
            str1.append(an);
        }
        return str1.toString();
    }
}
