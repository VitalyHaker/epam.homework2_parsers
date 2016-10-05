package by.tc.home02.dom;

import java.util.ArrayList;
import java.util.List;

public class SubPearl{
    private List<Dish> list = new ArrayList<>();
    private String name;

    public SubPearl() {
    }

    public List<Dish> getList() {
        return list;
    }

    public void setList(List<Dish> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

