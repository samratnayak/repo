package com.java.graph;

public class Percolation {

	private int[][] grid;
	private int openSites;
	private final int n;
	private boolean perculates = false;

	// boolean [][] isBlocked;
	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		grid = new int[n][n];
		int i = 0;
		int j = 0;
		while (i < n) {
			while (j < n) {
				grid[i][j] = 0;
				j++;
			}
			i++;
		}
	}

	public void open(int row, int col) {
		boolean isFull = false;
		if (row < 1 || row > n || col < 1 || col > n) {
			throw new IllegalArgumentException();
		}
		if (grid[row - 1][col - 1] == 0) {
			grid[row - 1][col - 1] = 1;
			openSites++;
			// check for eligibility of full
			if ((row != 1 && col != 1 && row != n && col != n) && (grid[row - 2][col - 1] == 2
					|| grid[row - 1][col - 2] == 2 || grid[row][col - 1] == 2 || grid[row - 1][col] == 2)) {
				grid[row - 1][col - 1] = 2;
				isFull = true;
			} else if (row == 1) {
				grid[row - 1][col - 1] = 2;
				isFull = true;
			} else if (col == 1) {
				if (row < n && (grid[row - 2][col - 1] == 2 || grid[row][col - 1] == 2 || grid[row - 1][col] == 2)) {
					grid[row - 1][col - 1] = 2;
					isFull = true;
				} else if (grid[row - 2][col - 1] == 2 || grid[row - 1][col] == 2) {
					grid[row - 1][col - 1] = 2;
					isFull = true;
				}
			} else if (col == n) {
				if (row < n
						&& (grid[row - 1][col - 2] == 2 || grid[row - 2][col - 1] == 2 || grid[row][col - 1] == 2)) {
					grid[row - 1][col - 1] = 2;
					isFull = true;
				} else if (grid[row - 1][col - 2] == 2 || grid[row - 2][col - 1] == 2) {
					grid[row - 1][col - 1] = 2;
					isFull = true;
				}
			} else if (row == n) {
				if (grid[row - 2][col - 1] == 2 || grid[row - 1][col - 2] == 2 || grid[row - 1][col] == 2) {
					grid[row - 1][col - 1] = 2;
					isFull = true;
				}
			}
		}
		checkPercolation(row, col, isFull);
	}

	private void checkPercolation(int row, int col, boolean isFull) {
		if (isFull)
			DFS(row - 1, col - 1, new boolean[n][n]);
		for (int i = 0; i < n; i++) {
			if (grid[n - 1][i] == 2) {
				perculates = true;
				break;
			}
		}
	}

	private void DFS(int i, int j, boolean[][] visited) {
		if (checkIndex(i, j)) {
			grid[i][j] = 2;
			visited[i][j] = true;
		} else {
			return;
		}
		if (checkIndex(i + 1, j) && !visited[i + 1][j] && grid[i + 1][j] >= 1)
			DFS(i + 1, j, visited);
		if (checkIndex(i, j + 1) && !visited[i][j + 1] && grid[i][j + 1] >= 1)
			DFS(i, j + 1, visited);
		if (checkIndex(i - 1, j) && !visited[i - 1][j] && grid[i - 1][j] >= 1)
			DFS(i - 1, j, visited);
		if (checkIndex(i, j - 1) && !visited[i][j - 1] && grid[i][j - 1] >= 1)
			DFS(i, j - 1, visited);

	}

	private boolean checkIndex(int i, int j) {
		return (i >= 0 && i < n) && (j >= 0 && j < n);
	}

	public boolean isOpen(int row, int col) {
		return grid[row - 1][col - 1] != 0;
	}

	public boolean isFull(int row, int col) {
		return grid[row - 1][col - 1] == 2;
	}

	public int numberOfOpenSites() {
		return openSites;
	}

	public boolean percolates() {
		return perculates;
	}

	public static void main(String[] args) {
		Percolation p = new Percolation(10);
		p.open(10, 1);
		p.open(1, 10);
		p.open(2, 10);
		p.open(2, 9);
		p.open(2, 8);
		p.open(3, 8);
		p.open(4, 8);
		p.open(5, 8);
		p.open(6, 8);
		p.open(7, 8);
		p.open(8, 8);
		p.open(9, 8);
		p.open(10, 8);

		// System.out.println(p.isOpen(10, 1));
		System.out.println(p.numberOfOpenSites());
		System.out.println(p.isFull(5, 9));
		System.out.println(p.percolates());
	}
}
