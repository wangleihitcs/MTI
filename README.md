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

## Batch Solve
Because it says you must only resquest no more than 10 time a minute and a request contains character no more than 10000. So we need batch solve.
* samples.txt like:
	* 00000011|your medical txt, ...
	* 00000012|your medical txt, ...
	* 00000013|your medical txt, ...
* result like:
	* 00000011|tag1|...
	* 00000011|tag2|...
	* 00000012|tag3|...
	* 00000013|tag1|...
* java code:
	* you should add "myGenericObj.setField("SingLinePMID", true);" to your java code.

## Conclusion
My code is very easy, and give some medical texts to let you test! Remember use absolute path！<br>
I have give the multi threads method in my code, so you can batch request Web API to solve batchs .txt files.
