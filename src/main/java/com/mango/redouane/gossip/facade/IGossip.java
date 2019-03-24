package com.mango.redouane.gossip.facade;

import java.util.List;

/**
 * Interface for result time gossip
 * @author RMehdi
 *
 */
public interface IGossip {

	/**
	 * Method return the result for given stores's tour
	 * 
	 * @param storesMango
	 * @return duration for gossiping
	 */
	String result(List<String> storesMango);

}
