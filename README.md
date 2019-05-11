Task is to create an application which does a Linux Path Traversal. You would be implementing various Linux commands, as follows.

cd path_name </br>
mkdir path_name </br>
rm path_name </br>
pwd </br>
ls </br>

There would be an additional command, for application purpose, which is

session clear <br>

It will clear all the previous operations and put back the application to starting point, as if application started just now.
Problem will have a command line environment, where testing input would be as command line input. 

At start, application would be at ROOT directory ‘/’. Overtime, application would be provided with various commands, your task is to successfully work on commands if there is a scope or throw error message.

We don’t want you to ‘actually’ create/remove real directories (using OS functions). Your application should keep a logical track of directories in a running session.

 <b>Examples: </b>

$ <Starting your application...> </br> 
$ pwd </br>
	PATH: / </br>
$ cd /some/random/path/which/doesn’t/exist </br>
	ERR: INVALID PATH </br>
$ mkdir dir1 </br>
	SUCC: CREATED </br>
$ mkdir dir1 </br>
	ERR: DIRECTORY ALREADY EXISTS </br>
$ mkdir dir2 </br>
	SUCC: CREATED </br>
$ ls </br>
	DIRS: dir1	dir2 </br> 
$ cd dir1 </br>
SUCC: REACHED </br>
$ pwd </br>
	PATH: /dir1 </br>
$ cd / </br>
	SUCC: REACHED </br>
$ rm /dir1 </br>
	SUCC: DELETED </br>
$ cd /dir1 </br>
	ERR: INVALID PATH </br>
$ mkdir /dir3 </br>
	SUCC: CREATED </br>
$ cd /dir2 </br>
	SUCC: REACHED </br>
$ pwd </br>
	PATH: /dir2 </br>
$ session clear </br>
	SUCC: CLEARED: RESET TO ROOT </br>
$ pwd </br>
	PATH: / </br>
$ asdf asdf </br>
	ERR: CANNOT RECOGNIZE INPUT. </br>
