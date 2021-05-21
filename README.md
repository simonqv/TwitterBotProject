# Twitter-bot Project
This is a project for the INDA course - DD1349.  

We will in this project implement a Twitter-bot that reads Swedish politicians tweets and then translates them  into 
rövarspråket and piglatin, depending if the tweet was in Swedish or English. 
The bot won't at people, because we don't want twitter to consider us spammers. So it will instead tweet "@/account" (with the slash, to prevent actaul at).

Chosen programming language: Java.

## Week 1

Mostly spent on set up. Such as creating a Twitter profile and applying for access to Twitter's API. 
We found the Twitter4j library to help us use the API. 
Started a maven project where we put the Twitter4j dependencies. Started organizing the project a bit. 


|Twitter account:  |                        |
|------------------|------------------------|
|**Usuername:**    |bandolero               |
|                  |@bandole19183971        |
|**Password:**     |Fråga Simon eller Sofia |
|**E-mail:**       | sofierik@kth.se        |
---

## Week 2
Had lots of problems with git. Which we mostly solved. (Unable to push and pull from one of the computers, unclear why...) 
Started to implement the program. Translator was at first implemented to only translate to rövarsråket. Implemented TweetReader 
to read tweets from the twitter feed. Tweeter was roughly implemented, it was only able to Tweet simple Strings we used as input. 

## Week 3
Some new problems with git... Which was solved again! 
Finished the translator. It can now translate to piglatin as well. It also returns a list, with the actual status and all its information (see Twitter4j),
and the translated tweet. This is to be able to use this as input in Tweeter, so that Tweeter can tweet the translation, together with info. 
The TranslatedStatus class was created for this. Started to connect the different methods and classes in Main, which is still sort of messy.
Continued with Tweeter, to make it Tweet the correct things. 

## Week 4

