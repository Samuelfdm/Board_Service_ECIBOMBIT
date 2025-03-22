//package edu.eci.arsw.Board.service;
//
//import edu.eci.arsw.Board.model.Board;
//import edu.eci.arsw.Board.model.Cell;
//import edu.eci.arsw.Board.model.CellType;
//import org.springframework.stereotype.Service;
//import java.util.*;
//
//@Service
//public class PredefinedMaps {
//
//    private static final List<String[]> MAPS = List.of(
//        new String[]{
//            "##########",
//            "#  #  #  #",
//            "# ## ## ##",
//            "#        #",
//            "#  ## ## #",
//            "# ## ##  #",
//            "#        #",
//            "## ## ## #",
//            "#  #  #  #",
//            "##########"
//        },
//        new String[]{
//            "##########",
//            "# #    # #",
//            "# ##  ## #",
//            "# ##  ## #",
//            "#   ##   #",
//            "#   ##   #",
//            "#  #  #  #",
//            "#  #  #  #",
//            "#        #",
//            "##########"
//        }
//    );
//
//    private static final Random random = new Random();
//
//    public Board generatePredefinedBoard(int gameId, List<Player> players) {
//        String[] selectedMap = MAPS.get(random.nextInt(MAPS.size())); // Selecciona un mapa aleatorio
//
//        int size = selectedMap.length;
//        Board board = new Board(gameId, size, size);
//        List<Cell> cells = new ArrayList<>();
//        Set<String> occupiedPositions = new HashSet<>();
//
//        // 1. Ubicar las paredes y casillas vacías
//        for (int y = 0; y < size; y++) {
//            for (int x = 0; x < size; x++) {
//                char symbol = selectedMap[y].charAt(x);
//                CellType type = switch (symbol) {
//                    case '#' -> CellType.INDESTRUCTIBLE;
//                    case '+' -> CellType.DESTRUCTIBLE;
//                    case ' ' -> CellType.EMPTY;
//                    default -> CellType.EMPTY;
//                };
//                cells.add(new Cell(x, y, type));
//            }
//        }
//
//        // 2. Ubicar a los jugadores en las esquinas
//        int[][] playerPositions = getPlayerStartPositions(players.size());
//        for (int i = 0; i < players.size(); i++) {
//            int x = playerPositions[i][0];
//            int y = playerPositions[i][1];
//            cells.add(new Cell(x, y, CellType.PLAYER));
//            occupiedPositions.add(x + "," + y);
//        }
//
//        // 3. Distribuir ítems de manera aleatoria en espacios vacíos
//        for (int i = 0; i < 5; i++) { // Se colocarán 5 ítems aleatorios
//            int x, y;
//            do {
//                x = random.nextInt(size);
//                y = random.nextInt(size);
//            } while (occupiedPositions.contains(x + "," + y));
//
//            cells.add(new Cell(x, y, CellType.ITEM));
//            occupiedPositions.add(x + "," + y);
//        }
//
//        board.setCells(cells);
//        return board;
//    }
//
//    private int[][] getPlayerStartPositions(int playerCount) {
//        return switch (playerCount) {
//            case 2 -> new int[][]{{0, 0}, {9, 9}};
//            case 3 -> new int[][]{{0, 0}, {9, 9}, {0, 9}};
//            case 4 -> new int[][]{{0, 0}, {9, 9}, {0, 9}, {9, 0}};
//            default -> throw new IllegalArgumentException("Número de jugadores no válido");
//        };
//    }
//}
