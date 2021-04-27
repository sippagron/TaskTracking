package tasktracking.services;

import java.util.ArrayList;

public class SearchCategoryGeneralTable {
    private ArrayList<String> seeCategory;

    public SearchCategoryGeneralTable(){
        seeCategory = new ArrayList<>();
    }

    public SearchCategoryGeneralTable(ArrayList<String> seeCategory){
        this.seeCategory = seeCategory;
    }

    public ArrayList<String> getSeeCategory(){
        return seeCategory;
    }
}
