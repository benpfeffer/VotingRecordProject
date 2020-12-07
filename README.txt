Congressional Voting Database Interface Project
By Salvador Balkus and Benjamin Pfeffer
CIS 452

Student IDs
Salvador Balkus: 01778781
Benjamin Pfeffer: 01791790

Overview
This folder contains our project, which provides an interface to add and query data from the Congressional Voting Database. 
Our data source can be found here: https://www.kaggle.com/voteview/congressional-voting-records. This represents data on the members, parties, votes, and rollcalls that occurred in the U.S. Senate and U.S. House of Representatives between 1789 and 2017. We put this data into an SQLite database using a csvs-to-sqlite converter (https://github.com/simonw/csvs-to-sqlite) and build a GUI interface that uses JDBC to interact with the database. 

Data
Our database can found and downloaded at the following link: https://www.dropbox.com/s/et84msslj6pp5k0/voting.db?dl=0 
Once downloaded, place the database file in the same folder as the rest of the project in order to run the executable file successfully. This was done because the database was too large to upload to myCourses.

Guide to subfolders
bin – contains .class files for the Eclipse project.
docs – contains our writings for this project, including:
-	Instruction Manual
-	Application Description + Project Schema + Functional Requirements
-	UML diagrams in image form
-	Development Wireframe for GUI

driver – contains the SQLite driver that we used for the project. Required to compile the code (make sure to add to classpath!) but is packaged with executable .jar file and not required to run application using the .jar file.

src – contains Java source code for the project (.java files). 

This main folder includes the executable .jar file. The software can be run by simply running this file – it
bundles everything needed besides the database. The database, which is called voting.db, is
included in the main folder as well. When running the executable .jar file, make sure it is in the same
folder as voting.db!
Finally, this folder also includes the .classpath and .project files that were used for the project in Eclipse. 
