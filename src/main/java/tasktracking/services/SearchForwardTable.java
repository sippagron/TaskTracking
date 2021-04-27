package tasktracking.services;

import tasktracking.models.ForwardWork;

import java.util.ArrayList;

public class SearchForwardTable {
    private ArrayList<ForwardWork> seeForward;

    public SearchForwardTable(){
        seeForward = new ArrayList<>();
    }

    public SearchForwardTable(ArrayList<ForwardWork> forwardWorks) {
        this.seeForward = forwardWorks;
    }

    public void addItem(ForwardWork forwardWork){
        this.seeForward.add(forwardWork);
    }

    public ArrayList<ForwardWork> getSearchForwardTable(){
        return seeForward;
    }
}
