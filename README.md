

# Sociology bookList _(Sociology bookList maintenance tool)_



## Table of Contents

- [Security](#security)
- [Background](#background)
- [Install](#install)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)



## Security

Do not encrypt.



## Background

I wanted to make a program instead of the web during winter vacation.  The department used Excel to search for books, and it seemed uncomfortable to record borrowers on the book list, so I tried it out because I thought it would be automated.



## Install

+ Eclipse
1. Make a file `jar`
	+ Right click `present project` -> Export -> Select `Runnable JAR file`  
2.. Run JAR file
	+ CMD -> Input " java -jar filePath\fileName.jar "



OR

+ jsmooth
+ bat



## Usage

+ `검색` btn
  + Search correct book-title in bookList.

+ `대출` btn
  + Show user data (userName, personNum, PH). 
  + Save user data in XSS file.
  + Decrease `int BookVolum` in XSS file.
  + If `BookVolum == 0`,  `대출`btn defuncted. 

+ `반납` btn
	+ Input book title in the search text bar and click `검색`btn.
	+ If the name of the book entered is correct, press the `반납`button. 
    	Then, disappear user data in Screen.






## Contributing
+ [JDBC](https://xinet.kr/?p=1591)


+ [APACHE POI](https://poi.apache.org/components/spreadsheet/quick-guide.html)


+ GUI
  + [Swing](https://coding-factory.tistory.com/263)    

+ Unite Test
  + [JUnit](https://epthffh.tistory.com/entry/Junit%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%8B%A8%EC%9C%84%ED%85%8C%EC%8A%A4%ED%8A%B8)


+ [How to run jar file?](https://yongtech.tistory.com/87)



## License

Copyright (c) <2020> <Joung DongSub>

[MY BLOG](https://dongsub-joung.github.io/archive.html?tag=%EB%8F%84%EC%84%9C%EA%B4%80%EB%A6%AC)



[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)
