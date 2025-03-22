package edu.eci.arsw.Board.controller;

import edu.eci.arsw.Board.dto.BoardRequestDTO;
import edu.eci.arsw.Board.dto.BoardResponseDTO;
import edu.eci.arsw.Board.model.Board;
import edu.eci.arsw.Board.service.BoardService;
//import edu.eci.arsw.Board.service.PredefinedMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private final BoardService boardService;

//    @Autowired
//    private PredefinedMaps predefinedMaps;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //Generacion de mapas

//    @PostMapping
//    public ResponseEntity<Board> generateBoard(@RequestParam int mapId) {
//        Board board = predefinedMaps.generatePredefinedBoard(mapId);
//        return ResponseEntity.ok(board);
//    }
//
//    @GetMapping("/maps")
//    public ResponseEntity<List<MapInfo>> getAvailableMaps() {
//        return ResponseEntity.ok(predefinedMaps.getMaps());
//    }

    //Operaciones Crud basicas

    @PostMapping
    public ResponseEntity<BoardResponseDTO> createBoard(@RequestBody BoardRequestDTO request) {
        return ResponseEntity.ok(boardService.createBoard(request));
    }

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable String id) {
        Optional<Board> board = boardService.getBoardById(id);
        return board.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable String id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
