package ru.job4j.collection;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        HashSet<String> noDubl = new HashSet<>();
        for (Task task: tasks) {
            noDubl.add(task.getNumber());
        } return noDubl;
    }
}
