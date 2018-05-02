package com.practice.datastructures;

public class Trees {
	
	/**
	 * A binary tree is a tree in which each node has up to 2 children. Not all
	 * trees are or need to be binary (ex. Suppose you were using a tree to
	 * represent a bunch of phone numbers. You'd probably want to use a 10-ary
	 * tree with each node having up to 10 children (one for each digit).
	 */

	/**
	 * Binary Tree vs. Binary Search Tree
	 * 
	 * A BST is a binary tree in which every node fits a specific ordering
	 * property: all left descendents <= n < all right descendents. This must be
	 * true for each node n.
	 * 
	 * Note: Under some definitions, the tree cannot have duplicate values. In
	 * others, the duplicate values will be on the right or can be on either
	 * side. Clarify this with your interviewer.
	 * 
	 * Ex. Binary Search Tree
	 * 
	 * 		8
	 * 	   / \
	 * 	  4  10
	 *   / \   \
	 * 2    6   20
	 * 
	 * Ex. Not a BST (note the 12)
	 * 
	 * 			8
	 * 		   / \
	 * 		  4   10
	 * 		 / \    \
	 * 		2   12   20
	 */

	/**
	 * Balanced Binary Trees
	 * 
	 * COMPLETE - a binary tree in which every level of the tree is fully filled
	 * except for perhaps the last level and it is filled left to right.
	 * 
	 * Ex. Complete BST					Not Complete BST
	 * 
	 * 			10						10
	 * 		   /  \					   /  \
	 * 		  5    20				  5    20
	 * 		/  \   /				/  \     \
	 *     3   7  15			   3    7      30
	 * 
	 * FULL - a binary tree in which every node has either 0 or 2 children (i.e.
	 * no nodes have only 1 child)
	 * 
	 * PERFECT - a binary tree that is both full and complete. All leaf nodes
	 * will be at the same level, and this level has the maximum number of
	 * nodes.
	 * 
	 * Ex. Perfect BT	(*** Note: the following is not a BST)
	 * 
	 * 				10
	 * 			   /  \
	 * 			 5     20
	 * 		    / \    / \
	 * 		  9   18  3   7
	 */

}
