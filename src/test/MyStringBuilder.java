package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class MyStringBuilder {
    // ---------- DO NOT Change ----------------
    ArrayList<Character> buff;

    public MyStringBuilder() {
        buff = new ArrayList<>();
    }

    public MyStringBuilder(char... ts) {
        buff = new ArrayList<>();
        for (char t : ts)
            buff.add(t);
    }

    // -----------------------------------------

    public MyStringBuilder append(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            buff.add(c);
        }
        return this;
    }

    public String toString() {
        char[] cs=new char[buff.size()];
        for(int i=0;i<cs.length;i++)
            cs[i]=buff.get(i);
        return new String(cs);
    }

    public MyStringBuilder reverse() {
        ArrayList<Character> arrayChars = new ArrayList<>();
        for (int i = buff.size() - 1; i >= 0; i--) {
            arrayChars.add(buff.get(i));
        }
        buff = arrayChars;

        return this;
    }

    public MyStringBuilder apply(UnaryOperator<Character> uop) {
        ArrayList<Character> t = buff;
        buff = new ArrayList<>();
        for (int i = 0; i < t.size(); i++)
            buff.add(uop.apply(t.get(i)));
        return this;
    }
}
