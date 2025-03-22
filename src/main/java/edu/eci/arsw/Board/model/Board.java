package edu.eci.arsw.Board.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "boards")
public class Board {
    @Id
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Board(int rows, int cols, List<Cell> cells) {
        this.rows = rows;
        this.cols = cols;
        this.cells = cells;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
