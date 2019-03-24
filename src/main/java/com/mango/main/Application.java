package com.mango.main;

import java.util.Arrays;

import com.mango.redouane.gossip.facade.GossipImpl;
import com.mango.redouane.gossip.facade.IGossip;

/**
 * Main class to run application
 * 
 * @author RMehdi
 *
 */
public class Application {

	public static void main(String[] args) {

		IGossip gossip = new GossipImpl();
		System.out.println("result : "+gossip.result(Arrays.asList(args)));

	}

}
