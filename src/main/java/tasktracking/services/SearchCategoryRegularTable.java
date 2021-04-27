package tasktracking.services;

import java.util.ArrayList;

public class SearchCategoryRegularTable {
    private ArrayList<String> seeCategory;

    public SearchCategoryRegularTable(){
        seeCategory = new ArrayList<>();
    }

    public SearchCategoryRegularTable(ArrayList<String> seeCategory){
        this.seeCategory = seeCategory;
    }

    public ArrayList<String> getSeeCategory(){
        return seeCategory;
    }
}
