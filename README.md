## Gossip code challenge for mango stores

# Exercise:
  People like to gossip, everyone knows that. And they will as soon as they are in the same Mango Store.

  So now we are going to calculate after how many store visits everybody knows all the gossips and can go home rest with their beloved families.

  You will be given the itinerary of each person having a walk on the downtown visiting the stores in an specific order. Each person starts with one gossip they are eager to share. Each itinerary is appointed to a person. When 2 or more people are at the same Mango store (even if it is the start), they can exchange all the gossips they know. An itinerary looks like this: Store1 Store2 Store3 Store4 and is repeated over the whole day like this Store1 Store2 Store3 Store4 Store1 Store2 Store3 Store4 Store1 Store2 Store3 … If someone starts and stops at the same Mango store then that is also repeated. Everyone takes 1 minute to go from one store to another(they are really fast…) and the gossip exchange happens instantly(…really really fast…). All of them buy clothes during 8 hours a day so you have a maximum of 480 minutes to get all the gossiping around.
  
  Tips

# Input Description
  You will receive all the people store routes. Not everyone has a route of the same length

Example 1:
  Store3 Store1 Store2 Store3
  Store3 Store2 Store3 Store1
  Store4 Store2 Store3 Store4 Store5

Example 2:
  Store2 Store1 Store2
  Store5 Store2 Store8

 

# Output Description
  The number of stops it takes to have all the people on board with the latest gossips. If there is even a single person who does not have all the gossips by the end of the day, the answer is never.

Example 1: 5
Example 2: never

To compile:
  mvn install

To run:
  java -jar target/gossip...jar "Store3 Store1 Store2 Store3" "Store3 Store2 Store3 Store1" "Store4 Store2 Store3 Store4 Store5"

