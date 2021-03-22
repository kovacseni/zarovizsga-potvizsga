package hu.nive.ujratervezes.zarovizsga.words;

import java.util.ArrayList;
import java.util.List;

public class Words {

    public boolean hasMoreDigits(String s) {
        List<String> digits = new ArrayList<>();
        List<String> others = new ArrayList<>();
        String digitString = "0123456789";

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);
            if (digitString.contains(temp)) {
                digits.add(temp);
            } else {
                others.add(temp);
            }
        }
        return (digits.size() > others.size());
    }
}
