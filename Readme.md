Minimum Scalar Product<br/>

Problem taken from Google Code JamRound 1A 2008:<br/>
https://code.google.com/codejam/contest/32016/dashboard#s=p0<br/>

Problem<br/>
You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). The scalar<br/>
product of these vectors is a single number, calculated as x1y1+x2y2+...+xnyn.<br/>

Suppose you are allowed to permute the coordinates of each vector as you wish.<br/>
Choose two permutations such that the scalar product of your two new vectors is<br/>
the smallest possible, and output that minimum scalar product.<br/>

Input<br/>
The first line of the input file contains integer number Tthe number of test<br/>
cases. For each test case, the first line contains integer number n. The next two<br/>
lines contain n integers each, giving the coordinates of v1 and v2 respectively.<br/>

Output<br/>
For each test case, output a line<br/>
Case #X: Y<br/>
where X is the test case number, starting from 1, and Y is the minimum scalar<br/>
product of all permutations of the two given vectors.<br/>

Limits<br/>
Small dataset<br/>
T = 1000<br/>
1 < n < 8<br/>
1000 < xi, yi < 1000<br/>

Large dataset<br/>
T = 10<br/>
100 < n < 800<br/>
100000 < xi, yi < 100000<br/>

Sample<br/>
Input<br/>
2<br/>
3<br/>
1 3 5<br/>
2 4 1<br/>
5<br/>
1 2 3 4 5<br/>
1 0 1 0 1<br/>
Output<br/>
Case #1: 25<br/>
Case #2: 6