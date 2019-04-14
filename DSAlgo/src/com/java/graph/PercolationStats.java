package com.java.graph;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private final int n, trials;
	private int[] dArr;
	private double mean;
	private double stddev;

	public PercolationStats(int n, int trials) {
		this.n = n;
		this.trials = trials;
	}

	public double mean() {
		dArr = new int[trials];
		for (int i = 0; i < trials; i++) {
			Percolation p = new Percolation(n);
			while (!p.percolates()) {
				int row = StdRandom.uniform(n) + 1;
				int col = StdRandom.uniform(n) + 1;
				p.open(row, col);
				/*
				 * System.out.println("Row "+row+" Col "+col+" Itr "+ (++itr) + "trial "+ i+
				 * "Total "+p.numberOfOpenSites()+"Percolates "+p.percolates());
				 */
			}
			if (p.percolates())
				dArr[i] = p.numberOfOpenSites();
		}
		mean = StdStats.mean(dArr) / (n * n);
		return mean;
	}

	public double stddev() {
		stddev = StdStats.stddev(dArr);
		stddev = stddev / (n * n);
		return stddev;
	}

	public double confidenceHi() {
		return (mean + bal());
	}

	private double bal() {
		return ((1.96 * stddev) / Math.sqrt(trials));
	}

	public double confidenceLo() {
		return mean - bal();
	}

	public static void main(String[] args) {
		PercolationStats p = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		System.out.println(p.mean());
		System.out.println(p.stddev());
		System.out.println(p.confidenceHi());
		System.out.println(p.confidenceLo());
	}
}
