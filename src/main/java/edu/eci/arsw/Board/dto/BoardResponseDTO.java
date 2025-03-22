package edu.eci.arsw.Board.dto;

import edu.eci.arsw.Board.model.Board;

public class BoardResponseDTO {
    private String id;
    private int rows;
    private int cols;
    private Board board;

    public BoardResponseDTO(String id, int rows, int cols, Board board) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.board = board;
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
