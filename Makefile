JFLAGS = -d classes -sourcepath src

.PHONY: all classes docs jar tests runtests clean

all: docs classes jar runtests 

classes:
	@mkdir -p classes
	javac $(JFLAGS) $$(find src -name "*.java")


docs:
	@mkdir -p docs
	javadoc -d docs -sourcepath src -subpackages game


jar: classes
	jar cfe towerdefense_b_random.jar game.Towerdefense_b_random -C classes .
	

tests: classes
	@mkdir -p classes/tests
	javac -classpath junit-console.jar:classes $$(find tests -name "*.java") -d classes/tests 

runtests: tests
	java -jar junit-console.jar -classpath classes/tests:classes -scan-classpath


execjar4aEx: 
	java -jar livrable4a.jar 10 10 5 

execjar4bEx: 
	java -jar livrable4b.jar 10 10 5 10

execjar5: jar
	java -jar livrable5.jar 10 10 5 

towerdefense_b_random: jar
	java -jar towerdefense_b_random.jar 10 10 5 

clean:
	rm -rf classes
	rm -rf docs
	rm -f livrable4a.jar livrable4b.jar livrable5.jar towerdefense_b_random

