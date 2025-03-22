package edu.eci.arsw.Board.service;

import edu.eci.arsw.Board.model.Board;
import edu.eci.arsw.Board.model.Cell;
import edu.eci.arsw.Board.model.CellType;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PredefinedMaps {

    private static final List<String[]> MAPS = List.of(
            new String[]{
                    "################",
                    "#      +       #",
                    "# ###### ####  #",
                    "# #    +    #  #",
                    "# # ###### #  ##",
                    "# # #    # #  ##",
                    "# # # ## # #  ##",
                    "# + # ## # #  ##",
                    "# # #    # #  ##",
                    "# # ###### #  ##",
                    "# #    +    #  #",
                    "# ###### ####  #",
                    "#      +       #",
                    "################"
            },
            new String[]{
                    "################",
                    "# # +    + #   #",
                    "# # ###### # # #",
                    "# #        # # #",
                    "# # ###### # # #",
                    "# + #    # + # #",
                    "# # # ## # # # #",
                    "# # # ## # # # #",
                    "# # #    # # # #",
                    "# # ###### # # #",
                    "# #        # # #",
                    "# # ###### # # #",
                    "# # +    + #   #",
                    "################"
            }
    );

    private static final Random random = new Random();

    public Board generateRandomBoard() {
        String[] map = MAPS.get(random.nextInt(MAPS.size()));
        List<Cell> cells = new ArrayList<>();

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length(); x++) {
                CellType type = switch (map[y].charAt(x)) {
                    case '#' -> CellType.WALL;
                    case '+' -> CellType.DESTRUCTIBLE;
                    default -> CellType.EMPTY;
                };
                cells.add(new Cell(x, y, type));
            }
        }
        return new Board(16, 16, cells);
    }

}
