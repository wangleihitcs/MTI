# MTI Project
## Introduce
NIM Medical Text Indexer, use its API to get tags from medical text. I have download its need jar libraries, and give an examples.<br>
Here is Web api link, https://ii.nlm.nih.gov/Web_API/index.shtml

## Libraries
* jars
  * skrAPI.jar 
  * httpclint.jar 
  * httpcore.jar
  * ...
* jdk 1.8 <br>

eg. All need jars exist MTI/libs, and you must apply an UMLS account to use its Web API. 

## Conclusion
My code is very easy, and give some medical texts to let you test! Remember use absolute path！<br>
I have give the multi threads method in my code, so you can batch request Web API to solve batchs .txt files.
