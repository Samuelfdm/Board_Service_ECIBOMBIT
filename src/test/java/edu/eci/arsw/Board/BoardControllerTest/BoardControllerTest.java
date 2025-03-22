//package edu.eci.arsw.Board.BoardControllerTest;
//
//import edu.eci.arsw.Board.model.Board;
//import edu.eci.arsw.Board.model.Cell;
//import edu.eci.arsw.Board.model.CellType;
//import edu.eci.arsw.Board.service.BoardService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BoardControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BoardService boardService; // Simulamos el servicio
//
//    @Test
//    public void testGetBoardById() throws Exception {
//        // Simulamos un tablero de 2x2
//        Board board = new Board(1, 2, 2);
//        board.setCells(List.of(
//            new Cell(0, 0, CellType.EMPTY),
//            new Cell(0, 1, CellType.DESTRUCTIBLE),
//            new Cell(1, 0, CellType.DESTRUCTIBLE),
//            new Cell(1, 1, CellType.EMPTY)
//        ));
//
//        // Configuramos el comportamiento del mock
//        Mockito.when(boardService.getBoardById(String.valueOf(1))).thenReturn(Optional.of(board));
//
//        // Ejecutamos la petición y verificamos la respuesta
//        mockMvc.perform(MockMvcRequestBuilders.get("/boards/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // Verificamos que el estado es 200 OK
//                .andExpect((ResultMatcher) jsonPath("$.id").value(1))
//                .andExpect((ResultMatcher) jsonPath("$.cols").value(2))
//                .andExpect((ResultMatcher) jsonPath("$.rows").value(2))
//                .andExpect((ResultMatcher) jsonPath("$.cells.length()").value(4)); // Verificamos que hay 4 celdas
//    }
//}
