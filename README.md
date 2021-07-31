# AI Search
This repository contains an implementation of both informed and uninformed popular search methods in AI.

## Project Definition :
The project has a 2D map. in the map there is player that needs to find a key and use this key to enter a castle. therefore the player must first go to the cell containing the key, and finally reach to the castle.
The player can only move to the 4 main directions and he must consider the amount of money and food he has. the players money and food can not be less than 0. so the player must carefully choose which cell to go.

### Cell Types:
The map contains different cell types:
#### Bridge:
The player can only go to these cells only once. unaccesable after the first presence.
#### Swamp:
The player can never go to these cells. These cells are forbidden.
#### Loot:
Each loot cell has a power. The player can choose to receive either money or food as much as the power of loot. but the player can only receive gifts for the first time. after the first presence this cell is treated as a normal cell.
#### Animal:
each animal cell has a power. every time the player goes to these cells, lose food as much as the power of animal.
#### Bandit:
each bandit cell has a power. every time the player goes to these cells, lose money as much as the power of bandit.
#### Castle:
It is only accessable if and only if the player has the key. by reaching this cell, the game finishes.
#### Key:
This cell contains the key and must be traversed in order to finish the game.

here I had implemented the following search methods:
## Uniformed Searches:
### BFS
### DFS
### DLS (Depth Limited Search)
### BDS (Bidirectional Search)

## Informed Searches:
Every kind of informed serach must have a heuristic function to give each node a value. The heuristic that I was working with, was a kind of problem relaxation.
I perform a BFS on the relaxed map (with just swamps and bridges) and use the depth of answer as the heuristic value of the node.
The Informed searches that I has implemented was:
### A*
### IDA*
### RBFS
