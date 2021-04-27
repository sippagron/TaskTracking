package tasktracking.services;

import tasktracking.models.GeneralWork;

import java.util.ArrayList;

public class SearchGeneralTable {
    private ArrayList<GeneralWork> seeGeneral;

    public SearchGeneralTable(){
        seeGeneral = new ArrayList<>();
    }

    public SearchGeneralTable(ArrayList<GeneralWork> generalWorks) {
        this.seeGeneral = generalWorks;
    }

    public void addItem(GeneralWork generalWork){
        this.seeGeneral.add(generalWork);
    }

    public ArrayList<GeneralWork> getSearchGeneralTable(){
        return seeGeneral;
    }
}
