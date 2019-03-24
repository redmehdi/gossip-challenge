package com.mango.redouane.gossip.facade;

import java.util.ArrayList;
import java.util.List;

import com.mango.redouane.gossip.process.GossipDetective;

/**
 * @author RMehdi
 *
 */
public class GossipImpl implements IGossip {
	
	private static final int _WORK_HOUR_DAY = 8;
	private static final int _WORK_TIME_MIN = _WORK_HOUR_DAY * 60;
	private static GossipDetective drivers;
	
	public GossipImpl() {
		drivers = new GossipDetective(_WORK_TIME_MIN);
	}


	/* (non-Javadoc)
	 * @see com.mango.redouane.gossip.facade.IGossip#result(java.util.List)
	 */
	@Override
	public String result(List<String> storesMango) {
		List<String[]> list = new ArrayList<>();
		for (String stores : storesMango) {
			String[] splitItems = stores.split(" ");
			list.add(splitItems);
		}
		String[][] input = new String[list.size()][];
		list.toArray(input);
		final Integer duration = drivers.getGossipTime(input);
		return duration <= 0 ? "never" : duration.toString();
	}
	
	
}
