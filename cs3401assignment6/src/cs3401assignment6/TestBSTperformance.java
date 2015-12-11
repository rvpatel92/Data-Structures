package cs3401assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestBSTperformance<E> 
{
	static int numbers = 5000;
	
		  public static void main(String[] args) 
		  {
			  BST<Integer> tree = new BST<Integer>();
			  for (int i = 0; i <= numbers; i++)
			  {
				  int randomint = (int) (Math.random() * i);
				  tree.insert(randomint);
			  }
		  //Checks how many nodes are in the tree
		  System.out.println("The number of nodes in the tree is " + tree.getSize());
		  System.out.println();
		  //Converted the tree into an arraylist
	      System.out.println("The array sorted into an arraylist is: \n" + tree.toArray());
	      System.out.println();
	      //Used the arraylist to shuffle the numbers
	      System.out.println("The array shuffled is: \n" + tree.toShuffle());
	      System.out.println("The time it takes to shuffle the content in the tree is " + getShuffleTime(tree) + " milliseconds.");
	      System.out.println();
	      //Creates a collection copy of the binary search tree to a collection tree2
	      Collection<Integer> tree2 = new ArrayList<Integer>(tree.toArray());
	      System.out.println();
	      //Perform Membership Search for a number
		  System.out.println("Member search time for the array list is " + getTestTime(tree2) + " milliseconds.");
		  System.out.println("Remove element time for the array list is " + getRemoveTime(tree2) + " milliseconds.");
	      System.out.println();
	    //Used the arraylist to shuffle the numbers for the second time
	      System.out.println("The array shuffled for the second time is: \n" + tree.toShuffle());
	      System.out.println("The time it takes to shuffle the content in the tree for the second time is " + getShuffleTime(tree) + " milliseconds.");
	      System.out.println();
	      
		  //Deletes all the numbers in the tree
	      for(int j = 0; j <= numbers; j++)
	      {
	    	  tree.delete(j);
	      }
		  System.out.println("The number of nodes in the tree is now " + tree.getSize() + ".");
		  }
		  
			
			public static long getShuffleTime(BST<Integer> t)
			{
				  long startTime = System.currentTimeMillis();
				  
				  Iterator<Integer> i = t.iterator();
				  ArrayList<Integer> list = new ArrayList<Integer>();

				  while (i.hasNext())
				  {
					  list.add(i.next());
				  }

				  t.clear();

				  Collections.shuffle(list);

				  i = list.iterator();

				  while (i.hasNext())
				  {
					  t.insert(i.next());
				  }
				  
				  return System.currentTimeMillis() - startTime; 
			}
			
			  public static long getTestTime(Collection<Integer> c) {
				    long startTime = System.currentTimeMillis();
				    // Test if a number is in the collection
				    for (int i = 0; i < numbers; i++)
				    c.add((int)(Math.random() * numbers));

				    return System.currentTimeMillis() - startTime; 
				  }
				  
				  public static long getRemoveTime(Collection<Integer> tree2) {
				    long startTime = System.currentTimeMillis();

				    // Remove all element from the collection
				    
				    for (int i = 0; i < numbers; i++)
				      tree2.remove(i);

				    return System.currentTimeMillis() - startTime; 
				    }

}

class BST<E extends Comparable<E>> 
extends AbstractTree<E> {
protected TreeNode<E> root;
protected int size = 0;

/** Create a default binary tree */
public BST() {
}

/** Create a binary tree from an array of objects */
public BST(E[] objects) {
for (int i = 0; i < objects.length; i++)
  insert(objects[i]);
}

//====================================================================

// Return the depth of a BST. Depth is the number of the nodes in

// the longest path of the tree.  // 

// Add code for method public int height()  here
//====================================================================
public int height() 
{
		return height(root);
}

public int height(TreeNode<E> root)
{
	if (root == null)
		return -1;
	else
		return Math.max(height(root.left), height(root.right)) + 1;
} 

//====================================================================

// Return the number of leaf nodes in a BST.
// 
// Add code for method public int getNumberOfLeaves() here
//====================================================================


public int getNumberofLeaves()
{
	return getNumberofLeaves(root);
}

public int getNumberofLeaves(TreeNode<E> root)
{
	if (root == null)
	{
		return 0;
	}
	if (root.left == null && root.right == null)
	{
	return 1;
	}
	else
	{
		return getNumberofLeaves(root.left) + getNumberofLeaves(root.right); 
	}
}


//====================================================================

// Return the number of non- leaf nodes in a BST.

// 

// Add code for method public int getNumberOfNonLeaves() here
//====================================================================


public int countNonLeaves()
{
	  return countNonLeaves(root);
}

public int countNonLeaves(TreeNode<E> root)
{
	if (root.left == null && root.right == null)
		return 0;
	else if (root.left == null)
		return 1 + countNonLeaves(root.right);
	else if (root.right == null)
		return 1 + countNonLeaves(root.left);
	else
		return 1 + countNonLeaves(root.left) + countNonLeaves(root.right); 
}

//////////////////////////////////////////////
//Here is the code to convert the binary search tree into an arrayList
public ArrayList<E> toArray()
{
	ArrayList<E> result = new ArrayList<E>();
	toArrayHelp(root,result);
	return result;
}

public void toArrayHelp(TreeNode ref, ArrayList<E> result)
{
	if (ref == null)
	{
		return;
	}
	
	toArrayHelp(ref.left, result);
	result.add((E) ref.element);
	toArrayHelp(ref.right, result);
}




//////////////////////////////////////////////
//Here is the code that shuffles the list
public ArrayList<E> toShuffle()
{
	ArrayList<E> result = new ArrayList<E>();
	toArrayHelp(root,result);
	Collections.shuffle(result);
	return result;
}
//////////////////////////////////////////////

//////////////////////////////////////////////
//Performance Test

public static long getShuffleTime(BST<Integer> t)
{
	  long startTime = System.currentTimeMillis();
	  
	  Iterator<Integer> i = t.iterator();
	  ArrayList<Integer> list = new ArrayList<Integer>();

	  while (i.hasNext())
	  {
		  list.add(i.next());
	  }

	  t.clear();

	  Collections.shuffle(list);

	  i = list.iterator();

	  while (i.hasNext())
	  {
		  t.insert(i.next());
	  }
	  
	  return System.currentTimeMillis() - startTime; 
}

///////////////////////////////////////////////////////


@Override /** Returns true if the element is in the tree */
public boolean search(E e) {
TreeNode<E> current = root; // Start from the root

while (current != null) {
  if (e.compareTo(current.element) < 0) {
    current = current.left;
  }
  else if (e.compareTo(current.element) > 0) {
    current = current.right;
  }
  else // element matches current.element
    return true; // Element is found
}

return false;
}

@Override /** Insert element o into the binary tree
* Return true if the element is inserted successfully */
public boolean insert(E e) {
if (root == null)
  root = createNewNode(e); // Create a new root
else {
  // Locate the parent node
  TreeNode<E> parent = null;
  TreeNode<E> current = root;
  while (current != null)
    if (e.compareTo(current.element) < 0) {
      parent = current;
      current = current.left;
    }
    else if (e.compareTo(current.element) > 0) {
      parent = current;
      current = current.right;
    }
    else
      return false; // Duplicate node not inserted

  // Create the new node and attach it to the parent node
  if (e.compareTo(parent.element) < 0)
    parent.left = createNewNode(e);
  else
    parent.right = createNewNode(e);
}

size++;
return true; // Element inserted
}

protected TreeNode<E> createNewNode(E e) {
return new TreeNode<E>(e);
}

@Override /** Inorder traversal from the root*/
public void inorder() {
inorder(root);
}

/** Inorder traversal from a subtree */
protected void inorder(TreeNode<E> root) {
if (root == null) return;
inorder(root.left);
System.out.print(root.element + " ");
inorder(root.right);
}

@Override /** Postorder traversal from the root */
public void postorder() {
postorder(root);
}

/** Postorder traversal from a subtree */
protected void postorder(TreeNode<E> root) {
if (root == null) return;
postorder(root.left);
postorder(root.right);
System.out.print(root.element + " ");
}

@Override /** Preorder traversal from the root */
public void preorder() {
preorder(root);
}

/** Preorder traversal from a subtree */
protected void preorder(TreeNode<E> root) {
if (root == null) return;
System.out.print(root.element + " ");
preorder(root.left);
preorder(root.right);
}

/** This inner class is static, because it does not access 
  any instance members defined in its outer class */
public static class TreeNode<E extends Comparable<E>> {
protected E element;
protected TreeNode<E> left;
protected TreeNode<E> right;

public TreeNode(E e) {
  element = e;
}
}

@Override /** Get the number of nodes in the tree */
public int getSize() {
return size;
}

/** Returns the root of the tree */
public TreeNode<E> getRoot() {
return root;
}

/** Returns a path from the root leading to the specified element */
public java.util.ArrayList<TreeNode<E>> path(E e) {
java.util.ArrayList<TreeNode<E>> list =
  new java.util.ArrayList<TreeNode<E>>();
TreeNode<E> current = root; // Start from the root

while (current != null) {
  list.add(current); // Add the node to the list
  if (e.compareTo(current.element) < 0) {
    current = current.left;
  }
  else if (e.compareTo(current.element) > 0) {
    current = current.right;
  }
  else
    break;
}

return list; // Return an array of nodes
}

@Override /** Delete an element from the binary tree.
* Return true if the element is deleted successfully
* Return false if the element is not in the tree */
public boolean delete(E e) {
// Locate the node to be deleted and also locate its parent node
TreeNode<E> parent = null;
TreeNode<E> current = root;
while (current != null) {
  if (e.compareTo(current.element) < 0) {
    parent = current;
    current = current.left;
  }
  else if (e.compareTo(current.element) > 0) {
    parent = current;
    current = current.right;
  }
  else
    break; // Element is in the tree pointed at by current
}

if (current == null)
  return false; // Element is not in the tree

// Case 1: current has no left children
if (current.left == null) {
  // Connect the parent with the right child of the current node
  if (parent == null) {
    root = current.right;
  }
  else {
    if (e.compareTo(parent.element) < 0)
      parent.left = current.right;
    else
      parent.right = current.right;
  }
}
else {
  // Case 2: The current node has a left child
  // Locate the rightmost node in the left subtree of
  // the current node and also its parent
  TreeNode<E> parentOfRightMost = current;
  TreeNode<E> rightMost = current.left;

  while (rightMost.right != null) {
    parentOfRightMost = rightMost;
    rightMost = rightMost.right; // Keep going to the right
  }

  // Replace the element in current by the element in rightMost
  current.element = rightMost.element;

  // Eliminate rightmost node
  if (parentOfRightMost.right == rightMost)
    parentOfRightMost.right = rightMost.left;
  else
    // Special case: parentOfRightMost == current
    parentOfRightMost.left = rightMost.left;     
}

size--;
return true; // Element inserted
}

@Override /** Obtain an iterator. Use inorder. */
public java.util.Iterator<E> iterator() {
return new InorderIterator();
}

// Inner class InorderIterator
private class InorderIterator implements java.util.Iterator<E> {
// Store the elements in a list
private java.util.ArrayList<E> list =
  new java.util.ArrayList<E>();
private int current = 0; // Point to the current element in list

public InorderIterator() {
  inorder(); // Traverse binary tree and store elements in list
}

/** Inorder traversal from the root*/
private void inorder() {
  inorder(root);
}

/** Inorder traversal from a subtree */
private void inorder(TreeNode<E> root) {
  if (root == null)return;
  inorder(root.left);
  list.add(root.element);
  inorder(root.right);
}

@Override /** More elements for traversing? */
public boolean hasNext() {
  if (current < list.size())
    return true;

  return false;
}

@Override /** Get the current element and move to the next */
public E next() {
  return list.get(current++);
}

@Override /** Remove the current element */
public void remove() {
  delete(list.get(current)); // Delete the current element
  list.clear(); // Clear the list
  inorder(); // Rebuild the list
}
}

/** Remove all elements from the tree */
public void clear() {
root = null;
size = 0;
}
}

	  abstract class AbstractTree<E> implements Tree<E> 
	  {
	  @Override /** Inorder traversal from the root*/
	  public void inorder() {
	  }

	  @Override /** Postorder traversal from the root */
	  public void postorder() {
	  }

	  @Override /** Preorder traversal from the root */
	  public void preorder() {
	  }

	  @Override /** Return true if the tree is empty */
	  public boolean isEmpty() {
	    return getSize() == 0;
	  }
	//
	//  @Override BLOCKCOMMENT* Return an iterator for the tree */
	//  public java.util.Iterator<E> iterator() {
//	    return null;
	//  }
	}
	  
	   interface Tree<E> extends Iterable<E> {
		  /** Return true if the element is in the tree */
		  public boolean search(E e);

		  /** Insert element o into the binary tree
		   * Return true if the element is inserted successfully */
		  public boolean insert(E e);

		  /** Delete the specified element from the tree
		   * Return true if the element is deleted successfully */
		  public boolean delete(E e);

		  /** Inorder traversal from the root*/
		  public void inorder();

		  /** Postorder traversal from the root */
		  public void postorder();

		  /** Preorder traversal from the root */
		  public void preorder();

		  /** Get the number of nodes in the tree */
		  public int getSize();

		  /** Return true if the tree is empty */
		  public boolean isEmpty();
		//
		//  BLOCKCOMMENT* Return an iterator to traverse elements in the tree */
		//  public java.util.Iterator<E> iterator();
		}
	   
	   
