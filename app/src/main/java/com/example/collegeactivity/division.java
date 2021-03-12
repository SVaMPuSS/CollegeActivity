package com.example.collegeactivity;

import java.util.Comparator;

public class division {
    private Integer id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Comparator<division> CompareById = new Comparator<division>() {
        @Override
        public int compare(division o1, division o2) {
            return o1.id.compareTo( o2.id );
        }
    };

    @Override
    public boolean equals( Object obj) {
        TypeEvent tp = (TypeEvent)obj;
        boolean res = (
                (this.id.equals(tp.getId()))&&
                (this.name.equals(tp.getName()))
        );
        return res;
    }
}
