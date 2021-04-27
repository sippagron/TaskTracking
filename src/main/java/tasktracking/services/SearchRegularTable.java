package tasktracking.services;

import tasktracking.models.RegularWork;

import java.util.ArrayList;

public class SearchRegularTable {
    private ArrayList<RegularWork> seeRegular;

    public SearchRegularTable(){
        seeRegular = new ArrayList<>();
    }

    public SearchRegularTable(ArrayList<RegularWork> regularWorks) {
        this.seeRegular = regularWorks;
    }

    public void addItem(RegularWork regularWork){
        this.seeRegular.add(regularWork);
    }

    public ArrayList<RegularWork> getSearchRegularTable(){
        return seeRegular;
    }
}
