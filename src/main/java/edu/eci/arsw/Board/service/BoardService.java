package edu.eci.arsw.Board.service;

import edu.eci.arsw.Board.model.Board;
import edu.eci.arsw.Board.repository.BoardRepository;
import edu.eci.arsw.Board.dto.BoardRequestDTO;
import edu.eci.arsw.Board.dto.BoardResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDTO createBoard(BoardRequestDTO request) {
        Board board = new Board(request.getRows(), request.getCols(), request.getCells());
        Board savedBoard = boardRepository.save(board);
        return new BoardResponseDTO(savedBoard.getId(), savedBoard.getRows(), savedBoard.getCols(), savedBoard);
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardById(String id) {
        return boardRepository.findById(id);
    }

    public void deleteBoard(String id) {
        boardRepository.deleteById(id);
    }
}
