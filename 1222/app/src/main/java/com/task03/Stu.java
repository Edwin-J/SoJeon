package com.task03;

/**
 * Created by Sunrin on 2016-12-21.
 */
public class Stu {

    private boolean isleft;
    private String name;
    private long id;

    public Stu(boolean isleft, String name, long id) {
        this.isleft = isleft;
        this.name = name;
        this.id = id;
    }

    public boolean isleft() {
        return isleft;
    }

    public void setIsleft(boolean isleft) {
        this.isleft = isleft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
