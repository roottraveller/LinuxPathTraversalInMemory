package model;

import common.Constants;

import java.util.*;

public class Directory {

    public static final Directory ROOT = new Directory();

    private String name;

    private final Map<String, Directory> children = new TreeMap<>();

    private Directory parent;

    public Directory() {
        name = "";
        this.children.put(".", this);
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.children.put(".", this);
        this.children.put("..", parent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Directory> getChildren() {
        return children;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", parent=" + parent +
                '}';
    }

    public String getPWD() {
        List<String> parentDirNames = new ArrayList<>();
        for (Directory tmp = this; tmp != Directory.ROOT;tmp=tmp.parent) {
            parentDirNames.add(tmp.name);
        }
        Collections.reverse(parentDirNames);
        return Constants.DIR_SEPARATOR + String.join(Constants.DIR_SEPARATOR, parentDirNames);
    }

    public String listChildDirNames() {
        return String.join("\t", children.keySet());
    }
}
