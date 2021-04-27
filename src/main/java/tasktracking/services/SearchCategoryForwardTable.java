package tasktracking.services;

import java.util.ArrayList;

public class SearchCategoryForwardTable {
    private ArrayList<String> seeCategory;

    public SearchCategoryForwardTable(){
        seeCategory = new ArrayList<>();
    }

    public SearchCategoryForwardTable(ArrayList<String> seeCategory){
        this.seeCategory = seeCategory;
    }

    public ArrayList<String> getSeeCategory(){
        return seeCategory;
    }
}
