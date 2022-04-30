Question: City Navigator 

Please read important information first. 


Description

In question package, you are given CityNavigator class. Inside this class,there is a method called pathFinder(String startCity, String targetCity). You are asked to completethis method and return the path length between two given cities. You will be doing the following: 
1.You are given a file called cities_and_distances. This file contains city, distance pairs such as: A-B:5. This shows that cities A and B are connected, and the distance between them is 5. First you need toread this file and store the elements. You can use arrays or arraylists on your implementation. Please do not use any otherdata structure that we have not seen in class.
2.Aim of pathFinder(String startCity, String targetCity) method is to find a path between two given cities,startCity and targetCity. Note that there can be more than one path between 2 cities, we will try to find the smallest distance.For example we can have these city pairs in file: A-B:5 B-C:4, and we want to find a path between A and C.We see that we can go to B from A and C from B, so there is a path between A and C and the total distance is 9. In this case,the method should return 9.
3.We want you to also store and print the path, the example given before should print [A-B,B-C] 
4.If there is no path between two given cities, you should return 0 as the distance. (This can happenif there is no connected path)


Important Notes: 
•Do not modify anything else in the code, except the specified area. Do not change the method name etc.
•This homework won't be graded, but you still need to make a submission.
•Do not use different data structures that we have not seen in class, such as graphs.


 
