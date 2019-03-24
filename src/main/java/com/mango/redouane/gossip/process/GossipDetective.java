package com.mango.redouane.gossip.process;

/**
 * Gossip algorithm class
 * 
 * @author RMehdi
 *
 */
public class GossipDetective {

	private long workTime;

	public GossipDetective(final long workTime) {
		this.workTime = workTime;
	}

	/**
	 * return number of time that takes to shares all gossip each
	 * 
	 * @param tours
	 * @return number time to share all gossip
	 */
	public int getGossipTime(final String[][] tours) {
		int t = 1;
		final int n = tours.length;
		int[] position = new int[n];

		// initialize gossip for each person
		boolean[][] gossiping = sharingGossip(n);

		while (t <= workTime) {
			String[] currentStops = new String[n];
			for (int i = 0; i < n; i++) {
				currentStops[i] = tours[i][position[i] % tours[i].length];
			}

			boolean allGossipKnown = allGossipShared(n, gossiping, currentStops);
			for (int i = 0; i < n; i++) {
				position[i] += 1;
			}
			if (allGossipKnown) {
				return t;
			}
			t++;
		}
		return 0;
	}

	/**
	 * Return true when all gossips share between all
	 * 
	 * @param size
	 * @param gossiping
	 * @param currentStops
	 * @param newGossip
	 * @return boolean
	 */
	private static boolean allGossipShared(final int size, final boolean[][] gossiping, final String[] currentStops) {
		boolean[] newGossip = new boolean[size];
		boolean allGossipShared = true;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (currentStops[i].equals(currentStops[j])) {
					for (int k = 0; k < size; k++) {
						newGossip[i] = newGossip[i] || (!gossiping[i][k] && gossiping[j][k]);
						newGossip[j] = newGossip[j] || (!gossiping[j][k] && gossiping[i][k]);
						gossiping[i][k] = gossiping[i][k] || gossiping[j][k];
						gossiping[j][k] = gossiping[i][k] || gossiping[j][k];
					}
				}
			}
			for (int j = 0; j < size; j++) {
				allGossipShared = allGossipShared && gossiping[i][j];
			}
		}
		return allGossipShared;
	}

	/**
	 * Return true for each person for knowing gossip
	 * 
	 * @param n
	 * 
	 * @return boolean
	 */
	private static boolean[][] sharingGossip(final int n) {
		boolean[][] gossiping = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				gossiping[i][j] = i == j;
			}
		}
		return gossiping;
	}

}
