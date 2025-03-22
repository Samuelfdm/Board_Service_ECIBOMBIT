package edu.eci.arsw.Board.dto;

import java.util.List;
import edu.eci.arsw.Board.model.Cell;

public class BoardRequestDTO {
    private int rows;
    private int cols;
    private List<Cell> cells;

    public BoardRequestDTO(int rows, int cols, List<Cell> cells) {
        this.rows = rows;
        this.cols = cols;
        this.cells = cells;
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
