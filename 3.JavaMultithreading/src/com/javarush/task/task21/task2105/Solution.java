package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Solution) || o == null) return false;
        Solution n = (Solution) o;
        if (first != null ? !first.equals(n.first) : n.first != null) return false;
        return last != null ? last.equals(n.last) : n.last == null;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}
