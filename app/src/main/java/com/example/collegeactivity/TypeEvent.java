package com.example.collegeactivity;

import android.graphics.Color;

import androidx.annotation.Nullable;

import java.util.Comparator;

public class TypeEvent {
    private Integer id;
    private String name;
    private Integer color;

    public TypeEvent(int id, String name, int color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public static Comparator<TypeEvent> CompareByName = new Comparator<TypeEvent>() {
        @Override
        public int compare(TypeEvent o1, TypeEvent o2) {
            return o1.getName().compareTo( o2.getName() );
        }
    };

    public static Comparator<TypeEvent> CompareById = new Comparator<TypeEvent>() {
        @Override
        public int compare(TypeEvent o1, TypeEvent o2) {
            return o1.id.compareTo( o2.id );
        }
    };

    @Override
    public boolean equals( Object obj) {
        TypeEvent tp = (TypeEvent)obj;
        boolean res = (
                (this.id.equals(tp.getId()))&&
                (this.name.equals(tp.getName()))&&
                (this.color.equals(tp.getColor()))
        );
        return res;
    }
}
