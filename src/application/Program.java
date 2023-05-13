package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		System.out.println("Óla mundo do Java");
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		Map<Color, List<ChessPiece>> capturedForPlayer = new EnumMap<>(Color.class);

		while (true) {
			try {
				UI.clearScreen();
				capturedForPlayer.computeIfAbsent(chessMatch.getCurrentPlayer(), k -> new ArrayList<ChessPiece>());
				UI.printMatch(chessMatch, capturedForPlayer.get(chessMatch.getCurrentPlayer()));

				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				Color currentPlayer = chessMatch.getCurrentPlayer();
				ChessPiece capturedPiece = chessMatch.executeChessMove(source, target);

				if (capturedPiece != null) {
					List<ChessPiece> list = capturedForPlayer.get(currentPlayer);
					list.add(capturedPiece);
				}

				UI.clearScreen();
				capturedForPlayer.computeIfAbsent(chessMatch.getCurrentPlayer(), k -> new ArrayList<ChessPiece>());
				UI.printMatch(chessMatch, capturedForPlayer.get(chessMatch.getCurrentPlayer()));
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				sc.nextLine();
			}
		}
	}
}
