/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greatlearning.labsolutions;

/**
 *
 * @author asus
 */

import java.util.ArrayList;

public class FindLongestPath {
    
     static class Node{
	   int nodeData ;
	   Node rightNode ;
	   Node leftNode ;
   }
private static Object root;;
   static Node newNode(int data) {
	   Node temp = new Node();
	   temp.nodeData = data;
	   temp.leftNode = null;
	   temp.rightNode = null;
	   return temp;
   }
   public static ArrayList<Integer> findLongestPath(Node root){
	// if root is null which means there is no binary tree
	   // then return empty list 
	   if(root == null) {
		 
		ArrayList<Integer> output = new ArrayList<Integer>();
		return output;
		
	}
	   //recursive call on root.right node
	   ArrayList<Integer> rightNodeList = findLongestPath(root.rightNode);
	  // recursive call on root.left node
	   ArrayList<Integer> leftNodeList = findLongestPath(root.leftNode);
   // comparing the size of two arraylist and accordingly inserting the current node
	   if(rightNodeList.size() < leftNodeList.size()) {
    	leftNodeList.add(root.nodeData);
    }else {
    	rightNodeList.add(root.nodeData);
    }
	   return leftNodeList.size()> rightNodeList.size() ? leftNodeList : rightNodeList;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Node root = newNode(100);
    root.leftNode = newNode(20);
    root.rightNode = newNode(130);
    root.leftNode.rightNode = newNode(50);
    root.leftNode.leftNode= newNode(10);
    root.rightNode.leftNode = newNode(110);
    root.rightNode.rightNode = newNode(140);
    root.leftNode.leftNode.leftNode = newNode(5);
    
    ArrayList<Integer> longestPath = findLongestPath(root);
    System.out.println(longestPath);
	
	
	}
}
