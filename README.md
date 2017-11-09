# My project's README

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=Threadcount -Darg3="words to delete" -Darg4=debugValue

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------
"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date:11/08/2017 ]

-----------------------------------------------------------------------
Our team used Binary Search Tree, it is a node based binary tree data structure
which uses the BST properties. The left sub tree of a nodes contains the nodes
less than the nodes key and the right sub tree of the nodes contains the nodes
greater than the nodes key. BST does not conains duplicate nodes.
The left and right subtree of BST must also follow BST properties.

If we want search the key in the BST, the search will first look up in the root,
if the key is present at the root, it would return root. If the key is greater than 
the roots key, it will traverse to right subtree of the root node else it recur 
to the left subtree.

BST is fast for insertion and search operations and put values in sorted order  

Complexity of BST

Worst case

insertion - O(log n)
deletion -  O(log n)
search - O(log n)

-----------------------------------------------------------------------
My Logger
In my logger, 
if the debug value is 4  -  Print to the stdout whenever the constructor is called
debug value is 3 -	Print to stdout everytime a thread's run() method is called
debug value is 2 - Print to stdout when an exception occurs
debug value is 1 - Print to stdout the final result
debug value is 0 - No output should be printed from the application to stdout. However, it doesn't affect what's get written to the output file
------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).