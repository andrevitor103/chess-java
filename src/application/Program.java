package application;

import boardgame.Board;

public class Program {

	public static void main(String[] args) {
		System.out.println("Óla mundo do Java");
		Board board = new Board(8, 8);
		System.out.println(board);
	}
}
