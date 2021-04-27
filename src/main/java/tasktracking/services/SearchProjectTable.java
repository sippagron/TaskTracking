package tasktracking.services;

import tasktracking.models.ProjectWork;

import java.util.ArrayList;

public class SearchProjectTable {
    private ArrayList<ProjectWork> seeProject;

    public SearchProjectTable(){
        seeProject = new ArrayList<>();
    }

    public SearchProjectTable(ArrayList<ProjectWork> projectWorks) {
        this.seeProject = projectWorks;
    }

    public void addItem(ProjectWork projectWork){
        this.seeProject.add(projectWork);
    }

    public ArrayList<ProjectWork> getSearchProjectTable(){
        return seeProject;
    }

}
