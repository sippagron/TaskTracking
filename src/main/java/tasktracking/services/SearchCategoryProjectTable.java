package tasktracking.services;

import java.util.ArrayList;

public class SearchCategoryProjectTable {
    private ArrayList<String> seeCategory;

    public SearchCategoryProjectTable(){
        seeCategory = new ArrayList<>();
    }

    public SearchCategoryProjectTable(ArrayList<String> seeCategory){
        this.seeCategory = seeCategory;
    }

    public ArrayList<String> getSeeCategory(){
        return seeCategory;
    }
}
