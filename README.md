# Mandatory Customer Database Homework
![Screenshot of "Mandatory Customer Database Homework"](http://www.globalnerdy.com/wordpress/wp-content/uploads/2016/06/pc-parts-customers.jpg)

* The third time I helped a friend with his Java homework and ended up doing the whole thing. ([Here's the repo for the first time I helped him](https://github.com/AccordionGuy/SortedFileWords), and [here's the repo for the second time](https://github.com/AccordionGuy/StatesCapitalsQuiz).)
* This application reads customer details from a database and displays them, allowing the user to specify which fields are visible and even do some basic
filtering by providing an SQL **WHERE** clause. As is my wont, I went a little bit beyond the basic spec to make the app a little nicer. My friend got full marks yet again.
* Written in Java 8 using NetBeans and JavaFX. This is the third Java project of *any* size that I've worked on since about 2000.

## Introduction
![Guy in a "Macklemore" thrift shop-like coat holding a Big Gulp and a football marked  '3-peat'n', with the caption 'F'n AWESOME'](http://www.globalnerdy.com/wordpress/wp-content/uploads/2016/06/threepeat.jpg)

With two successes under his belt -- [SortedFileWords](https://github.com/AccordionGuy/SortedFileWords) and
[StatesCapitalsQuiz](https://github.com/AccordionGuy/StatesCapitalsQuiz), my friend asked for my help on more time with the final assignment for his Java community college course. This time, it was the cliched-but-mandatory "access a database and display some of its contents" assignment.

Here's the text of the assignment (which for some reason was set in [Comic Sans](http://www.comicsanscriminal.com/)):

> Chapter 32 Custom Exercise:
Create a JavaFX GUI that allows the user to retrieve records from the customers table in the pcparts database.
The GUI should allow the user to specify desired fields, desired order, and a where condition.
Display only the desired fields in the desired order for the desired where condition.
You may display the records in the GUI in any way you wish

The user specifies the fields to display by checking checkboxes with the
names of the corresponding fields, enters and optional SQL `WHERE` clause
in a text box, and clicks the **Get Customer Data** button to update the  data display. The data itself is displayed in a `TableView`.

Once again, it was an evening's work, spent mostly Googling JDBC and
`ObservableList`s. My friend got full marks, and with the submission of this assignment, successfully completed the course.

## License
This code is released under the MIT license. Simply put, you're free to use this in your own projects, both personal and commercial, as long as
you include the MIT license text in your code. It would be nice if you mentioned my name somewhere in your documentation or credits if
you use this code, but it's not legally necessary. It would be nice, though.
