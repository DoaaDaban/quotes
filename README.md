# Quotes

## Lab-08

### Overview

In this lab I use the file **recentquotes.json** to show random popular book quotes and show the author.

## Methods and Library

* Used **GSON** library to parse the **json** file.

*  **`BufferedReader`** : It is a class from Java I/O classes, and it used for readind a reading files line by line.

## Architecture

The programing language used to build this project is Java.

## Lab-09: Web requests

### Overview

In this lab I get a quote from API and print it as output, also add the quote from API to the json file. If there problem in connection it will print a random quote from json file.

### Methods and Library

* In this lab I create a new class called  `QuoteAPI` to structure the data that comes from the API.

* I did not use any new methods, but what I do is create a new `QuoteAPI` variable to store the data that come from the API, then create `Quote` to generate a new quote and using the getter method from `QuoteAPI` to fill the text and author. the code bellows explain the idea:

```
QuoteAPI qutApi = gson.fromJson(bufferedReader,QuoteAPI.class);
Quote quotLocal = new Quote(null, qutApi.getAuthor(), null,qutApi.getQuote());

 ```

* After that I add the new quote to the `List<Quote>` which means it added to the json file.