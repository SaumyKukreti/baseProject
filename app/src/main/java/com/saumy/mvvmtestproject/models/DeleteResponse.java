package com.saumy.mvvmtestproject.models;

/**
 * Created by saumy on 2/27/2019.
 */

public class DeleteResponse {
    private int rowsDeleted;

    public DeleteResponse(int rowsDeleted) {
        super();
        this.rowsDeleted = rowsDeleted;
    }

    public int getRowsDeleted() {
        return rowsDeleted;
    }

    public void setRowsDeleted(int rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }

}

