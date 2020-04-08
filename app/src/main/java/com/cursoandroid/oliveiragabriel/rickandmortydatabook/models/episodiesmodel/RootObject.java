package com.cursoandroid.oliveiragabriel.rickandmortydatabook.models.episodiesmodel;

import java.util.List;

public class RootObject {


    private Info info;
    private List<Result> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
