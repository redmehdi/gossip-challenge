package com.mango.redouane.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.mango.redouane.gossip.facade.GossipImpl;
import com.mango.redouane.gossip.facade.IGossip;

/**
 * @author RMehdi
 *
 */
public class GossipTest {

	/**
	 * 
	 */
	@Test
	public void testGossipEx1() {
		IGossip gossip = new GossipImpl();
		List<String> routes = Stream.of("store3 store1 store2 store3", "store3 store2 store3 store1", "store4 store2 store3 store4 store5").map(String::new)
				.collect(Collectors.toList());
		assertThat("5", equalTo(gossip.result(routes)));
	}

	/**
	 * 
	 */
	@Test
	public void testGossipEx2() {
		IGossip gossip = new GossipImpl();
		List<String> routes = Stream.of("store2 store1 store2", "store5 store2 store8").map(String::new).collect(Collectors.toList());
		assertThat("never", equalTo(gossip.result(routes)));
	}

}
